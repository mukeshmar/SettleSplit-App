package live.mukeshtechlab.settlesplitapp.services.expenseService;

import live.mukeshtechlab.settlesplitapp.exceptions.InvalidGroupException;
import live.mukeshtechlab.settlesplitapp.exceptions.InvalidUserException;
import live.mukeshtechlab.settlesplitapp.models.*;
import live.mukeshtechlab.settlesplitapp.repositories.ExpenseRepository;
import live.mukeshtechlab.settlesplitapp.repositories.GroupRepository;
import live.mukeshtechlab.settlesplitapp.repositories.UserExpenseRepository;
import live.mukeshtechlab.settlesplitapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImp implements ExpenseService {
    private ExpenseRepository expenseRepository;
    private UserExpenseRepository userExpenseRepository;
    private UserRepository userRepository;
    private GroupRepository groupRepository;

    public ExpenseServiceImp(
            UserRepository userRepository,
            GroupRepository groupRepository,
            UserExpenseRepository userExpenseRepository, ExpenseRepository expenseRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.userExpenseRepository = userExpenseRepository;
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Expense addExpense(
            Long paidByUserId,
            String description,
            List<Long> owedByUserIds,
            int amount,
            Long groupId,
            ExpenseType type
    ) {
        // Check if user is present or not
        // check all owed by user ids are present or not
        // Create Expense object first
        // then creat UserExpense object because UserExpense object has Expense object

        Optional<User> paidByUserOptional = userRepository.findById(paidByUserId);

        if(paidByUserOptional.isEmpty()){
            throw new InvalidUserException("Invalid PaidBy User Id : " + paidByUserId);
        }

        User paidByUser = paidByUserOptional.get();

        List<User> owedByUserFromDb = new ArrayList<>();

        for(Long id : owedByUserIds){
            Optional<User> owedUserOptional = userRepository.findById(id);
            if(owedUserOptional.isEmpty()){
                throw new InvalidUserException("Invalid OwedBy User Id : " + id);
            }
            owedByUserFromDb.add(owedUserOptional.get());
        }

        Optional<Group> groupOptional = null;

        if(groupId != null){
            // Group
            groupOptional = groupRepository.findById(groupId);
            if(groupOptional.isEmpty()){
                throw new InvalidGroupException("Invalid group Id: " + groupId);
            }
        }

        Group group = groupId == null ? null : groupOptional.get();

        // Create the expense
        Expense expense = new Expense();
        expense.setDescription(description);
        expense.setAmount(amount);
        expense.setGroup(group);
        expense.setCreatedBy(paidByUser);
        expense.setType(type);

        // Initialize userExpenses list
        expense.setUserExpenses(new ArrayList<>());  // Initialize empty list
        expenseRepository.save(expense);

        // Calculate amount per participant
        int totalParticipant = owedByUserIds.size() + 1;
        int amountPerParticipant = amount / totalParticipant;

        // Create UserExpense for PaidBy user
        UserExpense paidByUserExpense = new UserExpense();
        paidByUserExpense.setUser(paidByUser);
        paidByUserExpense.setExpense(expense);
        paidByUserExpense.setAmount(amount - amountPerParticipant); // Assign remainder to paidByUser
        paidByUserExpense.setType(UserExpenseType.PAID);
        userExpenseRepository.save(paidByUserExpense);

        // Add it to the expense object's list
        expense.getUserExpenses().add(paidByUserExpense);

        // Create UserExpense for OwedBy users
        for (User owedByUser : owedByUserFromDb) {
            UserExpense owedByUserExpense = new UserExpense();
            owedByUserExpense.setUser(owedByUser);
            owedByUserExpense.setExpense(expense);
            owedByUserExpense.setAmount(-1 * amountPerParticipant);
            owedByUserExpense.setType(UserExpenseType.OWED);
            userExpenseRepository.save(owedByUserExpense);

            // Add it to the expense object's list
            expense.getUserExpenses().add(owedByUserExpense);
        }

        // Finally, update the expense with the userExpenses list
        expenseRepository.save(expense);

        return expense;
    }
}

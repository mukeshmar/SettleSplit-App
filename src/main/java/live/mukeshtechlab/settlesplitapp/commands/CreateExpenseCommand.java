package live.mukeshtechlab.settlesplitapp.commands;

import live.mukeshtechlab.settlesplitapp.controllers.ExpenseController;
import live.mukeshtechlab.settlesplitapp.dtos.expenseDto.AddExpenseRequestDto;
import live.mukeshtechlab.settlesplitapp.dtos.expenseDto.AddExpenseResponseDto;
import live.mukeshtechlab.settlesplitapp.models.ExpenseType;

import java.util.ArrayList;
import java.util.List;

public class CreateExpenseCommand implements Command {

    private ExpenseController expenseController;
    public CreateExpenseCommand(ExpenseController expenseController){
        this.expenseController = expenseController;
    }

    @Override
    public boolean matches(String input) {
        // sample input: u1 Expense u2 u3 u4 iPay 1000 Desc Last night dinner
        System.out.println("Checking if CreateExpenseCommand matches the input: " + input);
        List<String> words = List.of(input.split(" "));
        return words.get(1).equals(CommandKeyWords.CREATE_EXPENSE_COMMAND);
    }

    @Override
    public void execute(String input) {
        System.out.println("Executing CreateExpenseCommand");
        List<String> words = List.of(input.split(" "));
        Long paidByUserId = Long.valueOf(words.get(0));
        System.out.println("PaidBy User: " + paidByUserId);
        int i = 2;

        List<Long> owedByUserIds = new ArrayList<>();
        while (!words.get(i).equals("iPay")){
            Long owedByUserId = Long.valueOf(words.get(i));
            owedByUserIds.add(owedByUserId);
            i++;
        }
        System.out.println("OwedBy Users: " + owedByUserIds);

        // Skip iPay
        i++;

        int amount = Integer.parseInt(words.get(i));
        System.out.println("Amount: " + amount);

        while (!words.get(i).equals("Desc")){
            i++;
        }

        // Skip Desc
        i++;

        StringBuilder sbDescription = new StringBuilder();
        while (i<words.size()){
            sbDescription.append(words.get(i)).append(" ");
            i++;
        }
        String description = sbDescription.toString();
        System.out.println(description);

        // Call Expense Controller to Create Expense
        AddExpenseRequestDto addExpenseRequestDto = new AddExpenseRequestDto();
        addExpenseRequestDto.setPaidByUserId(paidByUserId);
        addExpenseRequestDto.setDescription(description);
        addExpenseRequestDto.setOwedByUserIds(owedByUserIds);
        addExpenseRequestDto.setAmount(amount);
        addExpenseRequestDto.setType(ExpenseType.DUMMY);

        AddExpenseResponseDto addExpenseResponseDto = expenseController.addExpense(addExpenseRequestDto);
        System.out.println("#### Expense is Successfully Created ####");
        System.out.println(addExpenseResponseDto.toString());

    }
}


/*
u1 Expense u2 u3 u4 iPay 1000 Desc Last night dinner

1 Expense 2 3 4 iPay 4000 Desc game parlor
2 Expense 3 4 iPay 6000 Desc salon
3 Expense 4 iPay 5000 Desc bank EMI
 */
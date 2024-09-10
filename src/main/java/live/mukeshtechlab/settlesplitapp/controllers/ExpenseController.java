package live.mukeshtechlab.settlesplitapp.controllers;

import live.mukeshtechlab.settlesplitapp.dtos.expenseDto.AddExpenseRequestDto;
import live.mukeshtechlab.settlesplitapp.dtos.expenseDto.AddExpenseResponseDto;
import live.mukeshtechlab.settlesplitapp.models.Expense;
import live.mukeshtechlab.settlesplitapp.services.expenseService.ExpenseService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    public AddExpenseResponseDto addExpense(AddExpenseRequestDto addExpenseRequestDto){
        Expense expense = expenseService.addExpense(
            addExpenseRequestDto.getPaidByUserId(),
            addExpenseRequestDto.getDescription(),
            addExpenseRequestDto.getOwedByUserIds(),
            addExpenseRequestDto.getAmount(),
            addExpenseRequestDto.getGroupId(),
            addExpenseRequestDto.getType()
        );
        return expense.toAddExpenseResponseDto();
    }
}

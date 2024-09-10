package live.mukeshtechlab.settlesplitapp.services.expenseService;

import live.mukeshtechlab.settlesplitapp.models.Expense;
import live.mukeshtechlab.settlesplitapp.models.ExpenseType;

import java.util.List;

public interface ExpenseService {
    Expense addExpense(
            Long paidByUserId,
            String description,
            List<Long> owedByUserIds,
            int amount,
            Long groupId,
            ExpenseType type
    );
}

package live.mukeshtechlab.settlesplitapp.dtos.expenseDto;

import live.mukeshtechlab.settlesplitapp.models.ExpenseType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddExpenseRequestDto {
    private Long paidByUserId;
    private String Description;
    private List<Long> owedByUserIds;
    private int amount;
    private Long groupId;
    private ExpenseType type;
}

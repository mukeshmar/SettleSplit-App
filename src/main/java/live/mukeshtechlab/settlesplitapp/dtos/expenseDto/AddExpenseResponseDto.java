package live.mukeshtechlab.settlesplitapp.dtos.expenseDto;

import live.mukeshtechlab.settlesplitapp.models.ExpenseType;
import live.mukeshtechlab.settlesplitapp.models.UserExpense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddExpenseResponseDto {
    private String paidByUserName;
    private int amount;
    private String description;
    private String groupName;
    private ExpenseType type;

    @Override
    public String toString(){
        return "AddExpenseResponseDto {\n" +
                "  PaidByUserName : " + this.paidByUserName + "\n" +
                "  Amount : " + this.amount + "\n" +
                "  Description : " + this.description + "\n" +
                "  GroupName : " + this.groupName + "\n" +
                "  ExpenseType: " + this.type + "\n" +
                "}";
    }
}

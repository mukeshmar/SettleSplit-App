package live.mukeshtechlab.settlesplitapp.models;

import jakarta.persistence.*;
import live.mukeshtechlab.settlesplitapp.dtos.expenseDto.AddExpenseResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel {
    private String description;
    private int amount;
    @ManyToOne
    private Group group;
    @ManyToOne
    private User createdBy;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseType type;
    @OneToMany(mappedBy = "expense")
    private List<UserExpense> userExpenses;

    public AddExpenseResponseDto toAddExpenseResponseDto(){
        AddExpenseResponseDto addExpenseResponseDto = new AddExpenseResponseDto();
        addExpenseResponseDto.setPaidByUserName(this.createdBy.getName());
        addExpenseResponseDto.setAmount(this.amount);
        addExpenseResponseDto.setDescription(this.description);
        addExpenseResponseDto.setGroupName(this.group == null ? null : this.group.getName());
        addExpenseResponseDto.setType(this.type);
        return addExpenseResponseDto;
    }
}


package live.mukeshtechlab.settlesplitapp.models;

import jakarta.persistence.*;
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
}

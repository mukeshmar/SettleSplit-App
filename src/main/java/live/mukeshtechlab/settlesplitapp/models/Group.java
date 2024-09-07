package live.mukeshtechlab.settlesplitapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "settleSplit_group")
public class Group extends BaseModel {
    private String name;
    private String description;
    @ManyToOne
    private User createdBy; // Group Admin
    @ManyToMany
    private List<User> members;
    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;
}

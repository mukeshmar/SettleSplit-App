package live.mukeshtechlab.settlesplitapp.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Transaction extends BaseModel {
    private Long fromUserId;
    private Long toUserId;
    private int amount;
}

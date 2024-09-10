package live.mukeshtechlab.settlesplitapp.repositories;

import live.mukeshtechlab.settlesplitapp.models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExpenseRepository extends JpaRepository <UserExpense, Long> {
}

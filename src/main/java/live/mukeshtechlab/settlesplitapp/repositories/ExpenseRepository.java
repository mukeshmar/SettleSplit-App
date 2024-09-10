package live.mukeshtechlab.settlesplitapp.repositories;

import live.mukeshtechlab.settlesplitapp.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}

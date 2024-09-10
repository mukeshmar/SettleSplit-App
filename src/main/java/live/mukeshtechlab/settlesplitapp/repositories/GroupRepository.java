package live.mukeshtechlab.settlesplitapp.repositories;

import live.mukeshtechlab.settlesplitapp.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository <Group, Long>{
}

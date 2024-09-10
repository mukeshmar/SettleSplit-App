package live.mukeshtechlab.settlesplitapp.repositories;

import live.mukeshtechlab.settlesplitapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhoneNumber(String phoneNumber);
    List<User> findAllByIdIn(List<Long> ids);
}

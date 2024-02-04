package whitera.rockpaperscissors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whitera.rockpaperscissors.entity.User;

public interface UserRepositoryInterface extends JpaRepository<User, Long> {
    User findByUsername(String username);
    boolean existsByUsername(String username);
}

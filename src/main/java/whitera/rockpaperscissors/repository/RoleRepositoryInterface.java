package whitera.rockpaperscissors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whitera.rockpaperscissors.entity.Role;

public interface RoleRepositoryInterface extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

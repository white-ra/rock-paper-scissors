package whitera.rockpaperscissors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whitera.rockpaperscissors.entity.GameSession;

public interface GameSessionRepositoryInterface extends JpaRepository<GameSession, Long> {

}

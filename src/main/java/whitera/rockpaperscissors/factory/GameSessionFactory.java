package whitera.rockpaperscissors.factory;

import org.springframework.stereotype.Service;
import whitera.rockpaperscissors.entity.GameSession;
import whitera.rockpaperscissors.entity.User;

@Service
public class GameSessionFactory {
    public GameSession create(String name, User owner) {
        GameSession gameSession = new GameSession();
        gameSession.setName(name);
        gameSession.setOwner(owner);

        return gameSession;
    }
}

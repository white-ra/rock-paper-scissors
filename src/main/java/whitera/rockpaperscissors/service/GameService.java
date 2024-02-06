package whitera.rockpaperscissors.service;

import org.springframework.stereotype.Service;
import whitera.rockpaperscissors.entity.GameSession;
import whitera.rockpaperscissors.factory.GameSessionFactory;
import whitera.rockpaperscissors.repository.GameSessionRepositoryInterface;
import whitera.rockpaperscissors.request.CreateGameSessionRequest;
import whitera.rockpaperscissors.response.CreateGameSessionResponse;

@Service
public class GameService {
    private final UserService userService;
    private final GameSessionFactory gameSessionFactory;
    private final GameSessionRepositoryInterface gameSessionRepository;

    public GameService(
        UserService userService,
        GameSessionFactory gameSessionFactory,
        GameSessionRepositoryInterface gameSessionRepository
    ) {
        this.userService = userService;
        this.gameSessionFactory = gameSessionFactory;
        this.gameSessionRepository = gameSessionRepository;
    }

    public CreateGameSessionResponse createGameSession(CreateGameSessionRequest createGameSessionRequest) {
        GameSession gameSession = gameSessionFactory.create(
            createGameSessionRequest.getName(),
            userService.getCurrentUser()
        );

        GameSession gameSessionFromDB = gameSessionRepository.save(gameSession);

        return new CreateGameSessionResponse(gameSessionFromDB.getId(), gameSessionFromDB.getName());
    }
}

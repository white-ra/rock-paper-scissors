package whitera.rockpaperscissors.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import whitera.rockpaperscissors.request.CreateGameSessionRequest;
import whitera.rockpaperscissors.response.CreateGameSessionResponse;
import whitera.rockpaperscissors.service.GameService;

@RestController
@RequestMapping("/api/game")
@Tag(name = "Game")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @Operation(summary = "Create game session")
    @PostMapping("/session/create")
    public CreateGameSessionResponse gameSessionGame(@RequestBody @Valid CreateGameSessionRequest request) {
        return gameService.createGameSession(request);
    }
}

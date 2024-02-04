package whitera.rockpaperscissors.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import whitera.rockpaperscissors.exception.BadRequestException;
import whitera.rockpaperscissors.exception.UsernameIsAlreadyTakenException;
import whitera.rockpaperscissors.request.SignInRequest;
import whitera.rockpaperscissors.request.SignUpRequest;
import whitera.rockpaperscissors.response.JwtAuthenticationResponse;
import whitera.rockpaperscissors.service.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication")
public class AuthorizationController {
    private final AuthenticationService authenticationService;

    public AuthorizationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Operation(summary = "User sign up")
    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid SignUpRequest request) throws BadRequestException {
        try {
            return authenticationService.signUp(request);
        } catch (UsernameIsAlreadyTakenException exception) {
            throw new BadRequestException(exception.getMessage());
        }
    }

    @Operation(summary = "User sign in")
    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request) {
        return authenticationService.signIn(request);
    }
}

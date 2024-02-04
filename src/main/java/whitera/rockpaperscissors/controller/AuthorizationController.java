package whitera.rockpaperscissors.controller;

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
public class AuthorizationController {
    private final AuthenticationService authenticationService;

    public AuthorizationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(value = "/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid SignUpRequest request) throws BadRequestException {
        try {
            return authenticationService.signUp(request);
        } catch (UsernameIsAlreadyTakenException exception) {
            throw new BadRequestException(exception.getMessage());
        }
    }

    @PostMapping(value = "/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request) {
        return authenticationService.signIn(request);
    }
}

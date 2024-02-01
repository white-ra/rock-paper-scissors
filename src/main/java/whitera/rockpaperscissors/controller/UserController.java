package whitera.rockpaperscissors.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import whitera.rockpaperscissors.exception.BadRequestException;
import whitera.rockpaperscissors.exception.LoginIsAlreadyTakenException;
import whitera.rockpaperscissors.request.RegistrationRequest;
import whitera.rockpaperscissors.service.RegistrationService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/user")
public class UserController {
    private final RegistrationService registrationService;

    public UserController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping(value = "/register", produces = APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Object> register(
            @RequestBody RegistrationRequest request
    ) throws BadRequestException {
        try {
            registrationService.register(request);
            return ResponseEntity.ok().build();
        } catch (LoginIsAlreadyTakenException exception) {
            throw new BadRequestException(exception.getMessage());
        }
    }
}

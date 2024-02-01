package whitera.rockpaperscissors.service;

import org.springframework.stereotype.Component;
import whitera.rockpaperscissors.exception.LoginIsAlreadyTakenException;
import whitera.rockpaperscissors.factory.UserFactory;
import whitera.rockpaperscissors.hasher.NotHashPasswordHasher;
import whitera.rockpaperscissors.hasher.PasswordHasher;
import whitera.rockpaperscissors.repository.UserHashMapRepository;
import whitera.rockpaperscissors.repository.UserRepositoryInterface;
import whitera.rockpaperscissors.request.RegistrationRequest;

@Component
public class RegistrationService {
    private final UserFactory userFactory;
    private final UserRepositoryInterface userRepository;
    private final PasswordHasher passwordHasher;

    public RegistrationService(UserFactory userFactory, UserHashMapRepository userRepository, NotHashPasswordHasher passwordHasher) {
        this.userFactory = userFactory;
        this.userRepository = userRepository;
        this.passwordHasher = passwordHasher;
    }

    public void register(RegistrationRequest registrationRequest) throws LoginIsAlreadyTakenException {
        if (null != userRepository.getByLogin(registrationRequest.login())) {
            throw new LoginIsAlreadyTakenException();
        }

        String passwordHash = passwordHasher.hash(registrationRequest.password());

        userRepository.add(userFactory.create(registrationRequest.login(), passwordHash));
    }
}

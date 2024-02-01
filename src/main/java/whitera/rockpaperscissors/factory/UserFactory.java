package whitera.rockpaperscissors.factory;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import whitera.rockpaperscissors.entity.User;

@Component
public class UserFactory {
    public @NotNull User create(String login, String hashPassword) {
        return new User(login, hashPassword);
    }
}

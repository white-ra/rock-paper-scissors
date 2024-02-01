package whitera.rockpaperscissors.hasher;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class NotHashPasswordHasher implements PasswordHasher{
    @Override
    public @NotNull String hash(String password) {
        return password;
    }
}

package whitera.rockpaperscissors.hasher;

import org.jetbrains.annotations.NotNull;

public interface PasswordHasher {
    @NotNull String hash(String password);
}

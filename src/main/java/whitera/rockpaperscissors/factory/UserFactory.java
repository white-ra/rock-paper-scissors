package whitera.rockpaperscissors.factory;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import whitera.rockpaperscissors.entity.Role;
import whitera.rockpaperscissors.entity.User;

import java.util.List;

@Component
public class UserFactory {
    public @NotNull User create(String username, String password, List<Role> roles) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRoles(roles);

        return user;
    }
}

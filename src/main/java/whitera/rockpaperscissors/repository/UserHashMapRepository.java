package whitera.rockpaperscissors.repository;

import org.springframework.stereotype.Component;
import whitera.rockpaperscissors.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class UserHashMapRepository implements UserRepositoryInterface {
    private Integer idCounter = 0;

    private Map<Integer, User> storage = new HashMap<>();

    public void add(User user)  {
        user.setId(idCounter);
        idCounter++;

        storage.put(user.getId(), user);
    }

    public User getByLogin(String login) {
        for (Map.Entry<Integer, User> entry : storage.entrySet()) {
            User user = entry.getValue();
            if (!Objects.equals(login, user.getLogin())) {
                continue;
            }

            return user;
        }

        return null;
    }
}

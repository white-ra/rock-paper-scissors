package whitera.rockpaperscissors.repository;

import whitera.rockpaperscissors.entity.User;

public interface UserRepositoryInterface {
    void add(User user);
    User getByLogin(String login);
}

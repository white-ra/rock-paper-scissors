package whitera.rockpaperscissors.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import whitera.rockpaperscissors.entity.User;
import whitera.rockpaperscissors.exception.UsernameIsAlreadyTakenException;
import whitera.rockpaperscissors.repository.UserRepositoryInterface;

@Service
public class UserService implements UserDetailsService {
    private final UserRepositoryInterface userRepository;

    public UserService(UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getByUsername(username);
    }

    public User getByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (null == user) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public User create(User user) throws UsernameIsAlreadyTakenException {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UsernameIsAlreadyTakenException();
        }

        return userRepository.save(user);
    }

    public User getCurrentUser() {
        return getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}

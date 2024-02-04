package whitera.rockpaperscissors.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import whitera.rockpaperscissors.entity.User;
import whitera.rockpaperscissors.exception.UsernameIsAlreadyTakenException;
import whitera.rockpaperscissors.factory.UserFactory;
import whitera.rockpaperscissors.repository.RoleRepositoryInterface;
import whitera.rockpaperscissors.request.SignInRequest;
import whitera.rockpaperscissors.request.SignUpRequest;
import whitera.rockpaperscissors.response.JwtAuthenticationResponse;

import java.util.Collections;

@Service
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserFactory userFactory;
    private final RoleRepositoryInterface roleRepository;

    public AuthenticationService(
        UserService userService,
        JwtService jwtService,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder,
        UserFactory userFactory,
        RoleRepositoryInterface roleRepository
    ) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userFactory = userFactory;
        this.roleRepository = roleRepository;
    }

    public JwtAuthenticationResponse signUp(SignUpRequest signUpRequest) throws UsernameIsAlreadyTakenException {
        User user = userFactory.create(
            signUpRequest.getUsername(),
            passwordEncoder.encode(signUpRequest.getPassword()),
            Collections.singleton(roleRepository.findByName("ROLE_USER"))
        );

        userService.create(user);

        return new JwtAuthenticationResponse(jwtService.generateToken(user));
    }

    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails user = userService.loadUserByUsername(request.getUsername());

        return new JwtAuthenticationResponse(jwtService.generateToken(user));
    }
}

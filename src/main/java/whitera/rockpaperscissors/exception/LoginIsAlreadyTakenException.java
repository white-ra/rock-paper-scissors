package whitera.rockpaperscissors.exception;

public class LoginIsAlreadyTakenException extends Exception {
    public LoginIsAlreadyTakenException() {
        super("Login is already taken!");
    }
}

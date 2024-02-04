package whitera.rockpaperscissors.exception;

public class UsernameIsAlreadyTakenException extends Exception {
    public UsernameIsAlreadyTakenException() {
        super("Username is already taken!");
    }
}

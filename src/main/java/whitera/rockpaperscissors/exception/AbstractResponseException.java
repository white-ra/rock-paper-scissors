package whitera.rockpaperscissors.exception;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;

abstract public class AbstractResponseException extends Exception {
    public AbstractResponseException(String message) {
        super(message);
    }

    abstract public @NotNull HttpStatus getHttpStatus();
}

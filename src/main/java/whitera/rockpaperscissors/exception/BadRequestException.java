package whitera.rockpaperscissors.exception;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;

public class BadRequestException extends AbstractResponseException {
    public BadRequestException(String message) {
        super(message);
    }

    @Override
    public @NotNull HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}

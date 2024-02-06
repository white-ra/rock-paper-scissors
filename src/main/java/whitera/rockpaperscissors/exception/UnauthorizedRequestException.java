package whitera.rockpaperscissors.exception;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;

public class UnauthorizedRequestException extends AbstractResponseException {
    public UnauthorizedRequestException(String message) {
        super(message);
    }

    @Override
    public @NotNull HttpStatus getHttpStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}

package whitera.rockpaperscissors.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import whitera.rockpaperscissors.exception.AbstractResponseException;
import whitera.rockpaperscissors.response.ResponseException;

@ControllerAdvice
public class GlobalResponseExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ResponseException> catchResponseException(AbstractResponseException exception) {
        return new ResponseEntity<>(new ResponseException(exception.getMessage()), exception.getHttpStatus());
    }
}

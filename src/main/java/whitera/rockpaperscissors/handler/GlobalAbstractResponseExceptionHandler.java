package whitera.rockpaperscissors.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import whitera.rockpaperscissors.exception.AbstractResponseException;
import whitera.rockpaperscissors.response.ExceptionResponse;

@ControllerAdvice
public class GlobalAbstractResponseExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> catchResponseException(AbstractResponseException exception) {
        return new ResponseEntity<>(new ExceptionResponse(exception.getMessage()), exception.getHttpStatus());
    }
}

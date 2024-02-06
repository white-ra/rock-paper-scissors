package whitera.rockpaperscissors.handler;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalValidationExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<String> catchResponseException(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();

        JsonArrayBuilder fieldErrorsArrayJsonBuilder = Json.createArrayBuilder();
        for (final FieldError fieldError : result.getFieldErrors()) {
            JsonObject errorObjectJson = Json
                .createObjectBuilder()
                .add("field", fieldError.getField())
                .add("message", StringUtils.capitalize(fieldError.getDefaultMessage()))
                .build();

            fieldErrorsArrayJsonBuilder.add(errorObjectJson);
        }

        JsonArray fieldsErrorsArrayJson = fieldErrorsArrayJsonBuilder.build();
        String errorsObjectJson = Json.createObjectBuilder().add("errors", fieldsErrorsArrayJson).build().toString();

        return new ResponseEntity<>(errorsObjectJson, HttpStatus.BAD_REQUEST);
    }
}

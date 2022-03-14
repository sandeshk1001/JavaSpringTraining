package SpringBasic.Day18.Exceptions;

import SpringBasic.Day20.Restapi.InvalidCredentialException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = InvalidCredentialException.class)
    public ResponseEntity<Object> handleException3(Exception exception) {
        return new ResponseEntity<>("Credentials are Invalid", HttpStatus.FORBIDDEN);
    }
}

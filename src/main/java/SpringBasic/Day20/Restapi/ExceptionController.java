package SpringBasic.Day20.Restapi;

import SpringBasic.Day20.SpringException.TweetNotFound;
import SpringBasic.Day20.SpringException.TweetNotFound2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = TweetNotFound.class)
    public ResponseEntity<Object> handleException(Exception exception) {
        return new ResponseEntity<>("Tweet not found", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = TweetNotFound2.class)
    public ResponseEntity<Object> handleException2(Exception exception) {
        return new ResponseEntity<>("Tweet 2 not found", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = InvalidCredentialException.class)
    public ResponseEntity<Object> handleException3(Exception exception) {
        return new ResponseEntity<>("Credentials are not valid", HttpStatus.FORBIDDEN);
    }
}
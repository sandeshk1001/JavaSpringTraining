package Assigments.Project.Exception;

import org.springframework.http.HttpStatus;

public class CommanException extends RuntimeException {
    private HttpStatus httpStatus;

    public CommanException(String message,HttpStatus httpStatus){
        super(message);
        this.httpStatus=httpStatus;
    }
}

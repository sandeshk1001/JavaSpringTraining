package Assigments.Project.Exception;

import Assigments.Project.Utils.Utility;
import SpringBasic.Day20.SpringException.TweetNotFound2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = CommanException.class)
    public ModelAndView handleError(CommanException ex){
        return Utility.errorMessageModelAndView(ex.getMessage());
    }
}

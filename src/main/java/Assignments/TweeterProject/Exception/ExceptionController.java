package Assignments.TweeterProject.Exception;

import Assignments.TweeterProject.Utils.Utility;
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

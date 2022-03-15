package Assigments.Project.Utils;

import Assigments.Project.Dao.Dao;
import Assigments.Project.ModelClasses.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

public class Utility {

    @Autowired
    static Dao<User> userDao;

    public static ModelAndView errorMessageModelAndView(String message) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.getModel().put("error", message);
        return modelAndView;
    }

    public static boolean containsInvalidPassword(String password) {
        if (password.equals(null))
            return true;
        return false;
    }

    public static boolean isContainsEmail(String email) {
        if (userDao.readByEmail(email).getEmail().equals(null))
            return false;
        return true;
    }

    public static boolean validateUser(String email,String password){
        User user=userDao.readByEmail(email);
        if (email.isEmpty() && user.getEmail().equals(email) && password.isEmpty() && user.getPassword().equals(password) )
            return false;
        return true;
    }

    public static boolean containsInvalidEmail(String email) {
        if (email.equals(null))
            return true;
        return false;
    }

    public static boolean containsInvalidChar(String name) {
        if (name.equals(null))
            return true;
        return false;
    }
}

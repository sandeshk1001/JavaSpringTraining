package SpringBasic.Day18.Exceptions;

import SpringBasic.Day18.Dao.Dao;
import SpringBasic.Day18.Dao.User;
import SpringBasic.Day18.Exceptions.ExceptionClasses.InvalidCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CradentialInterceptor implements HandlerInterceptor {
    @Autowired
    private Dao<User> userDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws InvalidCredentialException {
        User user=userDao.readById(2);
        if (user.equals(null))
            throw new InvalidCredentialException();
        return true;
    }
}
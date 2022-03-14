package TaskSpring_12March.Q6_DAOPattern.Dao;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MainDriver {
    public static void main(String[] args) {
        UserDao userDaoImpl2dao=new UserDaoImpl2();

        //print all users
        for (User user : userDaoImpl2dao.readAll()) {
            System.out.println("User: [Name : " + user.getName() + ", Email : " + user.getEmail() + " ]");
        }
    }
}

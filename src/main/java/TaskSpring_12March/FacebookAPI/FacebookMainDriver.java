package TaskSpring_12March.FacebookAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class FacebookMainDriver {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FacebookMainDriver.class,args);
    }
}

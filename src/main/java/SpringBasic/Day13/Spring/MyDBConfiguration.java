package SpringBasic.Day13.Spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
//@ImportResource("database-connection.xml")
public class MyDBConfiguration {
    @Bean
    @Scope("singleton")
    /*
        * prototype for create multiple instance of a single class
        * but in spring buy default singleton means only create one instance of a single class
     */
    public DatabaseConnectionSpring getDBConnection(){
        return new DatabaseConnectionSpring();
    }
}

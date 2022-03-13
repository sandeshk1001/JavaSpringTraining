package SpringBasic.Day13.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyDBConfiguration.class,args);
        DatabaseConnectionSpring springDBConnection =context.getBean(DatabaseConnectionSpring.class);
        DatabaseConnectionSpring springDBConnection1 =context.getBean(DatabaseConnectionSpring.class);
        System.out.println(springDBConnection.hashCode()+"  |  "+springDBConnection1.hashCode());
    }
}

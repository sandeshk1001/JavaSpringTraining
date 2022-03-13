package SpringBasic.Day14.autowiring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class,args);
        Address address = context.getBean(Address.class);
        Person person =context.getBean(Person.class);
        System.out.println(person.getName());
        System.out.println(person.getAddress().getHouseno());
    }
}

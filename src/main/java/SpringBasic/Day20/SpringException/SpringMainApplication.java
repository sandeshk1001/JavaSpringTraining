package SpringBasic.Day20.SpringException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringMainApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringMainApplication.class, args);
	}
}

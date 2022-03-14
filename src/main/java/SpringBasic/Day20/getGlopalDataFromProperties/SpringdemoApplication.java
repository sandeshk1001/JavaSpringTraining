package SpringBasic.Day20.getGlopalDataFromProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringdemoApplication.class, args);
		Tweet tweet=context.getBean(Tweet.class);
		System.out.println("Email: "+tweet.getEmail());
		System.out.println("Email: "+tweet.getPassword());
	}
}

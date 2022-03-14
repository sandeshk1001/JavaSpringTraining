package TaskSpring_12March.Q5;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Q5MainDriver {
        public static void main(String[] args) {
            ProcessData processData = new ProcessData();
            processData.Read();
        }

}

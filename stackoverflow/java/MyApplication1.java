import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@Import(MySecurityConfiguration.class)
public class MyApplication1 {
    public static void main(String[] args) {
        // SpringApplication.run(MyApplication1.class, args);
        // The above line is commented out because it's assumed to be a placeholder for the actual application startup code.
    }
}
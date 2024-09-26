import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({HelloWebSecurityConfiguration.class, AppConfiguration.class})
public class MySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }
}

@Configuration
class HelloWebSecurityConfiguration {
    // Define your security configuration here
}

@Configuration
class AppConfiguration {
    // Define your application configuration here
}
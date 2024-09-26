import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@Configuration
@Import(SecurityAutoConfiguration.class)
public class MyApplicationConfig {

    // Your application-specific beans go here
    @Bean
    public String exampleBean() {
        return "Example Bean";
    }
}
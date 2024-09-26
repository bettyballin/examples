import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SecurityConfig.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@Configuration
class SecurityConfig {

    @Bean
    public CPAuthenticationSuccessHandler cpAuthenticationSuccessHandler() {
        return new CPAuthenticationSuccessHandler();
    }
}

class CPAuthenticationSuccessHandler {
    // Implementation of CPAuthenticationSuccessHandler
}
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ...
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    public static void main(String[] args) {
        // SpringApplication.run(SecurityConfig.class, args); // Uncomment if using Spring Boot
        // Example usage
        SecurityConfig config = new SecurityConfig();
        try {
            config.configure(null); // Replace null with an actual HttpSecurity instance
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
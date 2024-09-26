import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp21 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
            .invalidSessionUrl("/login")
            .maximumSessions(1)
            .maxSessionsPreventsLogin(true);
    }

    public static void main(String[] args) {
        // Spring Boot application would typically be launched using SpringApplication.run(...)
        // This is just a placeholder; in a real application, Spring Boot would manage the execution.
        System.out.println("Spring Security configuration is set up.");
    }
}
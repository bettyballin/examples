import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig55urerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig55 extends WebSecurityConfig55urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and() // Ensure CORS is applied before Spring Security
            .csrf().disable(); // Disable CSRF protection for simplicity in this example
    }
}
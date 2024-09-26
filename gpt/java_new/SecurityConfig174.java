import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig174urerAdapter;

@Order(1)
@Configuration
@EnableWebSecurity
public class SecurityConfig174 extends WebSecurityConfig174urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // your security configuration goes here
    }

    // ... (other code remains the same)
}
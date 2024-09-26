import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig11urerAdapter;

@EnableWebSecurity
public class SecurityConfig11 extends WebSecurityConfig11urerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... your other configurations
            .headers()
                .cacheControl()
                .and()
            .frameOptions()
                .sameOrigin()
            // ... rest of your configuration
            ;
    }
}
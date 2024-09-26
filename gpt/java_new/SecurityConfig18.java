import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig18urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig18 extends WebSecurityConfig18urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... your other configurations

            .headers()
            .cacheControl()
            .and()
            .contentTypeOptions()
            .and()
            // ... rest of your security configuration
            .frameOptions().disable();
    }
}
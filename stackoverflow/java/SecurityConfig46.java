import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig46urerAdapter;

@Configuration
public class SecurityConfig46 extends WebSecurityConfig46urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // Other configurations
            .headers()
                .cacheControl().disable();
    }
}
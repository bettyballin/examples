import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Other configurations

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // Other configurations
                .headers()
                    .cacheControl().disable();
    }
}
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig35urerAdapter;

public class SecurityConfig35 extends WebSecurityConfig35urerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... your configuration ...
            .and()
                .csrf().disable();
    }
}
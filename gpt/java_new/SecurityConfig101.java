import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig101urerAdapter;

@EnableWebSecurity
public class SecurityConfig101 extends WebSecurityConfig101urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .sessionManagement()
                .invalidSessionUrl("/expired")
                // ... other configurations
                .and()
            .sessionManagement()
                .maximumSessions(1)
                .expiredUrl("/expired")
                .maxSessionsPreventsLogin(true);
                // ... other configurations
    }
}
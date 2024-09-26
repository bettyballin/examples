import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig100urerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class SecurityConfig100 extends WebSecurityConfig100urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // Your existing configuration...
            .sessionManagement()
                .invalidSessionUrl("/login?invalid")
                .maximumSessions(1)
                .expiredUrl("/login?expired")
                .and()
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
            // Additional configurations...
    }
}
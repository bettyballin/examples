import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig221urerAdapter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.AuthenticationManagerResolver;
import javax.servlet.http.HttpServletRequest;

@EnableWebSecurity
public class SecurityConfig221 extends WebSecurityConfig221urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... other configurations ...
            .oauth2ResourceServer(oauth2 -> oauth2.jwt());
    }

    private AuthenticationManager getAuthenticationManager() {
        // Implement your logic to create an AuthenticationManager instance
        return null;
    }
}
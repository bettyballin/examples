import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig41urerAdapter;

public class WebSecurityConfig41 extends WebSecurityConfig41urerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // Disable CSRF for all requests
            .csrf().ignoringAntMatchers("/services/rest/registerUser"); // Enable for specific requests
    }
}
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig45urerAdapter;

@EnableWebSecurity
public class SecurityConfig45 extends WebSecurityConfig45urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Your configuration code here
    }
}
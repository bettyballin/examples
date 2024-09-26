import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig136urerAdapter;

@EnableWebSecurity
public class SecurityConfig136 extends WebSecurityConfig136urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Your security configuration goes here
    }
}
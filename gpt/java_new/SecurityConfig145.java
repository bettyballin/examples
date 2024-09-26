import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig145urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig145 extends WebSecurityConfig145urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Your configuration here
    }
}
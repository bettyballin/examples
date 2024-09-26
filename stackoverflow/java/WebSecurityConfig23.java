import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig23urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig23 extends WebSecurityConfig23urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Your configuration code goes here
    }
}
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig80urerAdapter;

public class SecurityConfig80 extends WebSecurityConfig80urerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.anonymous().disable();
    }
}
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig90urerAdapter;

public class SecurityConfig90 extends WebSecurityConfig90urerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .loginPage("/logpage")
            .usernameParameter("custom-username-parameter-name");
    }
}
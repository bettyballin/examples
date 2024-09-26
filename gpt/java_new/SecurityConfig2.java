import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig2urerAdapter;

@EnableWebSecurity
public class SecurityConfig2 extends WebSecurityConfig2urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... other security configurations ...
            .rememberMe()
                .rememberMeParameter("remember-me")
                .tokenValiditySeconds(86400)
                .key("uniqueAndSecret");
            // ... further configurations ...
    }
}
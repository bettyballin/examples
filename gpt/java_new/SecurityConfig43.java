import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig43urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig43 extends WebSecurityConfig43urerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // configure authentication manager
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // configure http security
    }
}
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig23urerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig23 extends WebSecurityConfig23urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // other configuration...
            .authorizeRequests()
            .antMatchers("/forgot-password", "/reset-password").permitAll();
            // rest of the security configuration...
    }
}
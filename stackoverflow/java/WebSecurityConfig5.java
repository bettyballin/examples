import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig5urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig5 extends WebSecurityConfig5urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/users/**").access("hasRole('ROLE_ADMIN')")
            // ... other configurations
            ;
    }
}
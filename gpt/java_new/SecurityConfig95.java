import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig95urerAdapter;

@EnableWebSecurity
public class SecurityConfig95 extends WebSecurityConfig95urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ... existing configuration ...
        http
            .authorizeRequests()
                // Allow POST requests to /user without authentication
                .antMatchers(HttpMethod.POST, "/user").permitAll()
                // Need authentication for all other POST requests
                .antMatchers(HttpMethod.POST).authenticated()
                // Allow anonymous resource requests for all other requests
                .anyRequest().permitAll();
        // ... rest of your configuration ...
    }
}
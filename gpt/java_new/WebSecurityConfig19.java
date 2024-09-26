import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig19urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig19 extends WebSecurityConfig19urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... other configuration ...
            .authorizeRequests()
                // ... other antMatchers ...
                // Allow only POST requests to /api/subscription
                .antMatchers(HttpMethod.POST, "/api/subscription").permitAll()
                // Explicitly deny other HTTP methods for /api/subscription
                .antMatchers("/api/subscription").denyAll()
                .antMatchers("/api/**").authenticated()
                // ... other configuration ...
            // ... further configurations such as formLogin or httpBasic ...
            ;
    }
}
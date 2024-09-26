import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig6urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig6 extends WebSecurityConfig6urerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... other configuration ...
            .requiresChannel()
                .requestMatchers(r -> "https".equals(r.getHeader("X-Forwarded-Proto")))
                .requiresSecure()
            .and()
            .requiresChannel()
                .antMatchers("/secure/**").requiresSecure()
                .antMatchers("/insecure/**").requiresInsecure();
    }
}
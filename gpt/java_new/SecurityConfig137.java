import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig137urerAdapter;

public class SecurityConfig137 extends WebSecurityConfig137urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... other configuration ...
            .authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated();
            // ... other configuration ...
    }
}
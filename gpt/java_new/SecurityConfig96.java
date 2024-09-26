import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig96urerAdapter;

public class SecurityConfig96 extends WebSecurityConfig96urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... other configurations ...
            .authorizeRequests()
                .antMatchers("/api/url/available/without/login").permitAll()
                .anyRequest().authenticated();
            // ... other configurations ...
    }
}
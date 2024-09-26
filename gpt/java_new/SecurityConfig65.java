import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig65urerAdapter;

@EnableWebSecurity
public class SecurityConfig65 extends WebSecurityConfig65urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF protection
            .headers().xssProtection().disable() // Disable XSS protection
            .and()
            .authorizeRequests()
                .anyRequest().permitAll() // Permit all requests without authentication
            .and()
            .formLogin().disable() // Disable form login
            .httpBasic().disable(); // Disable HTTP Basic authentication
    }
}
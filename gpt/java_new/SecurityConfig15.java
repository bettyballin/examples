import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig15urerAdapter;

@EnableWebSecurity
public class SecurityConfig15 extends WebSecurityConfig15urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .rememberMe()
                // configure your remember-me settings here
                .and()
            .authorizeRequests()
                .antMatchers("/your-resource").access("hasRole('ROLE_USER') or hasAuthority('ROLE_ANONYMOUS')")
                // ... other configuration
                .anyRequest().authenticated()
                .and()
            // ... other configuration
            .formLogin()
                .and()
            .httpBasic();
    }
}
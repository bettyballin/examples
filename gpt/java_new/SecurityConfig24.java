import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig24urerAdapter;

@EnableWebSecurity
public class SecurityConfig24 extends WebSecurityConfig24urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... your other security configurations
            .authorizeRequests()
                .antMatchers("/_ah/queue/**").permitAll() // Adjust the pattern to match your task queue worker URLs
                .anyRequest().authenticated()
            .and()
            // ... other configurations like formLogin, httpBasic,
            // Remember to add the closing braces for method and class
            ;
    }
}
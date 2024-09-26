import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig223urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig223 extends WebSecurityConfig223urerAdapter {

    // ... your existing configuration

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Your security configuration here
        http
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .and()
            .httpBasic();
    }
}
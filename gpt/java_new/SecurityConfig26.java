import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig26urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig26 extends WebSecurityConfig26urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... other security configurations ...
            .authorizeRequests()
                .antMatchers("/res/nonsecured/**").permitAll()
                .antMatchers("/res/secured/**").authenticated();
            // ... additional security configurations ...
    }
}
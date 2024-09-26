import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig72urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig72 extends WebSecurityConfig72urerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // configure authentication manager
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... other configurations ...
            .authorizeRequests()
                .antMatchers("/non-secure/**").permitAll()
                .antMatchers("/secure/**").hasAuthority("USER")
                .and()
            .requiresChannel()
                .antMatchers("/secure/**").requiresSecure()
                .antMatchers("/non-secure/**").requiresInsecure(); // Explicitly allow HTTP for non-secure
    }
}
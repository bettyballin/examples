import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Disable all security configurations
        http.authorizeRequests().anyRequest().permitAll();

        // Optional: If you want to disable CSRF protection
        http.csrf().disable();

        // Optional: If you don't need form login or HTTP Basic authentication
        http.formLogin().disable()
                .httpBasic().disable();
    }

}
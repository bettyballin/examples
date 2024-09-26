import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Disable CSRF
        http.csrf().disable();

        // Authorize requests
        http
            .authorizeRequests()
                .antMatchers("/adduser").hasRole("ADMIN")
                .anyRequest().authenticated() // Add this line to handle other requests
            .and()
            .formLogin(); // Enable form login for illustration
    }
}
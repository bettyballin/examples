import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig57urerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig57 extends WebSecurityConfig57urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // other configuration before...
            
            // Allow anonymous access for a specific pattern from localhost
            .authorizeRequests()
                .antMatchers("/specific-pattern").hasIpAddress("127.0.0.1")
                .anyRequest().authenticated()
            .and()
                // other configurations after...
                ;
    }
}
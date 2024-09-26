import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/**/*.html").authenticated() // require authentication for URLs ending with ".html"
            .anyRequest().permitAll() // allow all other requests
            .and()
            .csrf().disable(); // disable CSRF protection

        // ... additional configuration ...
    }

    // ... other methods and configurations ...

}
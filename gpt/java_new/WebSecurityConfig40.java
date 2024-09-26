import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig40urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig40 extends WebSecurityConfig40urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/subscribe/**").permitAll();
            // ... other matchers
    }
}
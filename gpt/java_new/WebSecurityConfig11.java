import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig11urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig11 extends WebSecurityConfig11urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/about", "/about/", "/about.*").hasRole("USER")
                // ... other configurations
                .anyRequest().authenticated();
    }
}
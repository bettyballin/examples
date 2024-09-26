import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig69urerAdapter;

@EnableWebSecurity
public class SecurityConfig69 extends WebSecurityConfig69urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/index", "/", "/ajouterFiliere")
            .hasAnyRole("RM", "RF");
        // ... other configurations
    }
}
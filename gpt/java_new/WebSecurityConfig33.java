import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig33urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig33 extends WebSecurityConfig33urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... other configurations ...
            .headers()
                .defaultsDisabled() // disable defaults
                .cacheControl().disable(); // disable cache control headers
    }
}
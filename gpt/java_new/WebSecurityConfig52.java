import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig52urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig52 extends WebSecurityConfig52urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/jobs").hasRole("my_user")
            .antMatchers(HttpMethod.GET, "/desks").hasRole("my_user")
            // ... any other antMatchers configuration
            .anyRequest().denyAll(); // This will deny access to any request not matched above
    }
}
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig31urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig31 extends WebSecurityConfig31urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/your-entity/**").permitAll()
                .antMatchers("/api/your-entity/**").authenticated()
            // ... other configurations ...
            ;
        // ... continue configuration ...
    }
}
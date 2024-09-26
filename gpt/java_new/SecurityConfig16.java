import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig16urerAdapter;

public class SecurityConfig16 extends WebSecurityConfig16urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... other configuration ...
            .authorizeRequests()
                .antMatchers("/faq.html").permitAll()
            // ... other rules ...
            // ... other configuration ...
            ;
    }
}
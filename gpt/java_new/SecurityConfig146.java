import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig146urerAdapter;

@EnableWebSecurity
public class SecurityConfig146 extends WebSecurityConfig146urerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .x509()
                .and()
            .csrf()
                .disable();
    }
}
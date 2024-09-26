import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig115urerAdapter;

public class SecurityConfig115 extends WebSecurityConfig115urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .anyRequest().anonymous()
            .and()
            .anonymous().authorities("ANONYMOUS");
    }
}
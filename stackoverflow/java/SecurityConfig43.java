import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig43urerAdapter;

@EnableWebSecurity
public class SecurityConfig43 extends WebSecurityConfig43urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .sessionManagement()
                .maximumSessions(1)
                .and()
            .invalidSessionUrl("/expired");
    }
}
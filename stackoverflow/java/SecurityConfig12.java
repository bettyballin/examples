import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig12urerAdapter;

public class SecurityConfig12 extends WebSecurityConfig12urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
            .authenticationEntryPoint(new org.springframework.security.web.authentication.Http403ForbiddenEntryPoint());
    }
}
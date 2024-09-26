import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

public class SecurityConfig42 {
    public void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().authenticationEntryPoint(new Http403ForbiddenEntryPoint());
        http.authorizeRequests().antMatchers("/uri/**").hasAuthority("SOME_ROLE");
    }
}
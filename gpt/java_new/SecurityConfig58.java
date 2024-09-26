import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig58urerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@EnableWebSecurity
public class SecurityConfig58 extends WebSecurityConfig58urerAdapter {

    private final AccessDeniedHandler accessDeniedHandler;

    public SecurityConfig58(AccessDeniedHandler accessDeniedHandler) {
        this.accessDeniedHandler = accessDeniedHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // Other configuration ...
            .exceptionHandling()
            .accessDeniedHandler(accessDeniedHandler);
    }
}
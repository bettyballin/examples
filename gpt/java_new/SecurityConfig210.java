import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig210urerAdapter;

@EnableWebSecurity
public class SecurityConfig210 extends WebSecurityConfig210urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .requestMatchers(new RequestMatcher() {
                @Override
                public boolean matches(HttpServletRequest request) {
                    return "POST".equals(request.getMethod()) && "/api/something".equals(request.getServletPath());
                }
            })
            .access("isAuthenticated() or hasIpAddress('172.17.0.0/24')");
    }
}
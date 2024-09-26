import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Http403ForbiddenEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         org.springframework.security.core.AuthenticationException authException) throws IOException {
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
    }
}

class SecurityConfig {

    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... your existing configuration ...
            .exceptionHandling()
            .authenticationEntryPoint(new Http403ForbiddenEntryPoint());
            // ... rest of your configuration ...
    }
}
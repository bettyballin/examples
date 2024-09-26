import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityConfig160 {

    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
            .accessDeniedHandler(new AccessDeniedHandler() {
                @Override
                public void handle(javax.servlet.http.HttpServletRequest request,
                                   HttpServletResponse response,
                                   org.springframework.security.access.AccessDeniedException accessDeniedException)
                        throws IOException {
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    response.getWriter().write("Access Denied!");
                }
            });
    }
}
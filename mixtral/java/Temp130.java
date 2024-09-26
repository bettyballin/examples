import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.access.AccessDeniedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ...

        http
            .exceptionHandling()
                .accessDeniedHandler(new CustomAccessDeniedHandler());
    }

    class CustomAccessDeniedHandler implements AccessDeniedHandler {

        @Override
        public void handle(HttpServletRequest request, HttpServletResponse response,
                           AccessDeniedException accessDeniedException) throws IOException, ServletException {

            // Get required authorities from the header
            String[] requiredAuthorities = request.getHeader("Sec-RequiredAuthorities").split("\\");

            // Redirect to appropriate page based on missing authority
            // Example: redirect to a custom error page
            response.sendRedirect("/access-denied");
        }
    }

    public static void main(String[] args) {
        // Your application entry point
    }
}
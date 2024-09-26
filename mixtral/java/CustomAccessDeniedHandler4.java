import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException exception) throws IOException, ServletException {

        // Handle the case when a user tries to access an unauthorized page

        if (exception instanceof InsufficientAuthenticationException ||
            (exception.getCause() != null &&
            exception.getCause().getClass().isAssignableFrom(InsufficientAuthenticationException.class))) {
            response.sendRedirect("/403");
        }
    }
}
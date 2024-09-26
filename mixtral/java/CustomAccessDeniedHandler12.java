import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final AccessDeniedException accessDeniedException) throws IOException, ServletException {

        // Redirect to your custom error page
        String redirectUrl = "/accessDenied";

        if (request.getHeader("X-Requested-With") != null
                && request.getHeader("X-Requested-With").equalsIgnoreCase(
                    "XMLHttpRequest")) {
            // Special handling for AJAX requests
            response.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage());
        } else {
            response.sendRedirect(redirectUrl);
        }

    }
}
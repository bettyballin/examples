import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // Handle the exception here

        if (accessDeniedException instanceof AuthenticationCredentialsNotFoundException
                || (accessDeniedException.getCause() != null
                && accessDeniedException.getCause().getClass().equals(AuthenticationCredentialsNotFoundException.class))) {
            response.sendRedirect("/login");
        }
    }
}
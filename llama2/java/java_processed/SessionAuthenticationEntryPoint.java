import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        // Check if a session already exists
        HttpSession session = request.getSession(false);
        if (session != null && !session.isNew()) {
            // If a session exists and it's not new, return 401 Unauthorized
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // Redirect the user to the CAS login page
        response.sendRedirect("/login"); // You can replace "/login" with the actual CAS login URL
    }
}
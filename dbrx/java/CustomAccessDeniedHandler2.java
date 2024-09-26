import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        
        // Extract the required role from the request (assuming it's passed as a parameter)
        String requiredRole = request.getParameter("requiredRole");

        // Customize the response
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("text/plain"); // Set the content type
        response.getWriter().write("Access Denied. Required role: " + requiredRole);
    }
}
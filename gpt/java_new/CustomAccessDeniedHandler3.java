import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAccessDeniedHandler3 implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {
        // Custom logic to handle access denied
        // You can use request.getRequestURI() to get the attempted URL
        // And use SecurityContextHolder.getContext().getAuthentication() to get user details and roles

        // Logic to determine the required role and where to redirect
        // ...

        response.sendRedirect("your_redirect_url_based_on_role");
    }
}
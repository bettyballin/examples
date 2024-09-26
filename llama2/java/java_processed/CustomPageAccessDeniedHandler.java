import org.springframework.stereotype.Component;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomPageAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        String currentPage = request.getRequestURI();
        // Check if the user has permission to view the current page
        boolean hasPermission = checkPagePermission(currentPage);

        if (!hasPermission) {
            response.sendRedirect("/403");
        } else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
        }
    }

    private boolean checkPagePermission(String currentPage) {
        // Here you can check the user's role and determine if they have permission to view the page
        // For example:
        String[] allowedPages = {"/page1", "/page2"};
        for (String allowedPage : allowedPages) {
            if (currentPage.equals(allowedPage)) {
                return true;
            }
        }

        return false;
    }
}
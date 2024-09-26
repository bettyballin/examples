import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        // Invalidate the HTTP session.
        if (request.getSession() != null) {
            request.getSession().invalidate();
        }

        // Clear any authentication details from the security context.
        SecurityContextHolder.clearContext();

        // Redirect to SiteMinder logout URL.
        String siteminderLogoutUrl = "/siteminderagent/logout";
        response.setStatus(HttpServletResponse.SC_OK);
        response.sendRedirect(request.getContextPath() + siteminderLogoutUrl);
    }
}
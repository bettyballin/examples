import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.filter.WebAsyncManagerIntegrationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomLogoutHandler implements LogoutHandler {
    private final boolean invalidateHttpSession;
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CustomLogoutHandler.class);

    public CustomLogoutHandler(boolean invalidateHttpSession) {
        this.invalidateHttpSession = invalidateHttpSession;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (this.invalidateHttpSession) {
            HttpSession session = request.getSession(false);

            if (session != null && !request.isRequestedSessionIdValid()) {
                logger.debug("Invalidating session: " + session.getId());

                try {
                    session.invalidate();
                } catch (IllegalStateException ex) {
                    // Handle exception if needed
                }

                request.removeAttribute(WebAsyncManagerIntegrationFilter.WEB_ASYNC_MANAGER_ATTRIBUTE);
            }
        }

        // Do not clear authentication or context if required
    }
}
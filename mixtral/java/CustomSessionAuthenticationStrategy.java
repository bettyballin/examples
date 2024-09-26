import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomSessionAuthenticationStrategy implements SessionAuthenticationStrategy {

    private static final int INACTIVITY_TIMEOUT = 15 * 60; // in seconds

    @Override
    public void onAuthentication(Authentication authentication, HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

        if (authentication != null && !request.getSession().isNew()) {

            long lastActivityTime = getLastActivityTimeFromSession(request);

            // Check for inactivity
            boolean isInactive = System.currentTimeMillis() - lastActivityTime > INACTIVITY_TIMEOUT * 1000;

            if (isInactive) {
                request.getSession().invalidate();

                response.sendRedirect("/login?expired=true");

                return;

            }

        }

    }

    private long getLastActivityTimeFromSession(HttpServletRequest request) {
        // Placeholder implementation; you should replace this with actual logic to retrieve the last activity time
        return System.currentTimeMillis() - (10 * 60 * 1000); // Example: last activity was 10 minutes ago
    }

}
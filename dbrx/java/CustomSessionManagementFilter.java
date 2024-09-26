import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.security.web.util.RedirectStrategy;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.CollectionUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

public class CustomSessionManagementFilter extends SessionManagementFilter {

    private final RedirectStrategy redirectStrategy;

    public CustomSessionManagementFilter(SessionAuthenticationStrategy sessionAuthenticationStrategy, RedirectStrategy redirectStrategy) {
        super(sessionAuthenticationStrategy);
        this.redirectStrategy = redirectStrategy;
    }

    @Override
    protected void onExpiredSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);

        if (session != null && !isRequestInProcess(request)) {
            String originalUrl = getOriginalUrl(session);
            redirectStrategy.sendRedirect(request, response, "/login?original=" + URLEncoder.encode(originalUrl, "UTF-8"));

            // Clear the saved request so that it doesn't interfere with future requests.
            clearSavedRequest(request);
        }
    }

    private void storeSessionType(HttpSession session) {
        // Store information about the type of session here.
    }

    private String getOriginalUrl(HttpSession session) {
        SavedRequest savedRequest = (SavedRequest) session.getAttribute("SPRING_SECURITY_SAVED_REQUEST");

        if (savedRequest != null && !CollectionUtils.isEmpty(savedRequest.getRedirectUrls())) {
            return savedRequest.getRedirectUrls().get(0);
        }
        return "/";
    }

    private boolean isRequestInProcess(HttpServletRequest request) {
        // Implement the logic to determine if the request is in process.
        return false;
    }

    private void clearSavedRequest(HttpServletRequest request) {
        // Implement the logic to clear the saved request.
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("SPRING_SECURITY_SAVED_REQUEST");
        }
    }
}
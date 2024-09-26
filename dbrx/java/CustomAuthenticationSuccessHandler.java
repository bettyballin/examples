import org.springframework.security.core.Authentication;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.DefaultRedirectStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    private final RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        String targetUrl = determineTargetUrl(request, response);

        if (response.isCommitted()) {
            System.out.println("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    private String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        // Retrieve the pre-login URL from your custom storage (e.g database or cache)
        String savedRequest = retrieveSavedRequestFromCustomStorage();

        if (savedRequest != null && !savedRequest.isEmpty()) {
            return savedRequest;
        } else {
            // If no stored value is found, fall back to Spring Security's default behavior
            SavedRequest savedRequestObj = requestCache.getRequest(request, response);
            String targetUrl;

            if (savedRequestObj == null) {
                targetUrl = "/default-page";
            } else {
                targetUrl = savedRequestObj.getRedirectUrl();
            }

            return targetUrl;
        }
    }

    // Implement this method to retrieve the pre-login URL from your custom storage
    private String retrieveSavedRequestFromCustomStorage() {
        // Your logic here...
        // For demonstration purposes, return an empty string
        return "";
    }
}
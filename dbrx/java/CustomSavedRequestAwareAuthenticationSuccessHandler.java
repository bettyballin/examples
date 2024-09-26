import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.security.web.savedrequest.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomSavedRequestAwareAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private String changePasswordUrl;
    private String welcomeUrl;
    private RequestCache requestCache;

    public void setChangePasswordUrl(String changePasswordUrl) {
        this.changePasswordUrl = changePasswordUrl;
    }

    public void setWelcomeUrl(String welcomeUrl) {
        this.welcomeUrl = welcomeUrl;
    }

    @Override
    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
        super.setRequestCache(requestCache);
    }

    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !isLocalAuthMode(authentication)) {
            SavedRequest savedRequest = requestCache.getRequest(request, response);
            if (savedRequest == null || isChangePasswordOrWelcomePage(savedRequest.getRedirectUrl(), request)) {
                return changePasswordUrl;
            }
        }

        String targetURL = super.determineTargetUrl(request, response);

        // Add your custom logic here to modify the `targetURL` as needed.

        return targetURL;
    }

    private boolean isLocalAuthMode(Authentication authentication) {
        // Implement this method based on how you determine local auth mode.
        return false; // Placeholder implementation
    }

    private boolean isChangePasswordOrWelcomePage(String redirectUrl, HttpServletRequest request) {
        String contextPath = request.getContextPath();
        return (redirectUrl.endsWith(changePasswordUrl)
                || redirectUrl.endsWith(contextPath + welcomeUrl));
    }
}
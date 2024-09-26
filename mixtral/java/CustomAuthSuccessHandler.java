import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);

        if (savedRequest != null && !StringUtils.isEmpty(savedRequest.getRedirectUrl())) {
            return savedRequest.getRedirectUrl();
        }

        // Fallback to default behavior
        String targetUrl = super.determineTargetUrl(request, response);

        request.getSession().setAttribute("SPRING_SECURITY_SAVED_REQUEST", null);

        return targetUrl;
    }
}
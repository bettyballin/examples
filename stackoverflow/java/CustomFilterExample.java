import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.core.Authentication;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;

import java.io.IOException;
import javax.servlet.ServletException;

public class CustomFilterExample {

    private Filter ssoFilter(ClientResources client, String path) {
        OAuth2ClientAuthenticationProcessingFilter clientFilter = new OAuth2ClientAuthenticationProcessingFilter(path);
        .......
        clientFilter.setAuthenticationSuccessHandler(new UrlParameterAuthenticationHandler());
        return clientFilter;
    }

    public class UrlParameterAuthenticationHandler extends SimpleUrlAuthenticationSuccessHandler {

        @Override
        protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
                throws IOException, ServletException {
            String targetUrl = determineTargetUrl(request, response);

            if (response.isCommitted()) {
                logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
                return;
            }

            String queryString = HttpUtils.removeParams(request.getQueryString(), "state", "code");
            targetUrl = !StringUtils.isEmpty(queryString) ? targetUrl + "?" + queryString : targetUrl;
            getRedirectStrategy().sendRedirect(request, response, targetUrl);
        }
    }
}
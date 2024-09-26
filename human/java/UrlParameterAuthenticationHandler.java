import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SsoFilterExample {

    private Filter ssoFilter(ClientResources client, String path) {
        OAuth2ClientAuthenticationProcessingFilter clientFilter = new OAuth2ClientAuthenticationProcessingFilter(path);
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

    // Mock classes to make the code executable
    public static class ClientResources {
    }

    public static class HttpUtils {
        public static String removeParams(String queryString, String... params) {
            // Logic to remove params from query string
            return queryString;
        }
    }

    public static class StringUtils {
        public static boolean isEmpty(String str) {
            return str == null || str.isEmpty();
        }
    }

    public static void main(String[] args) {
        // Example usage
        SsoFilterExample example = new SsoFilterExample();
        ClientResources clientResources = new ClientResources();
        Filter filter = example.ssoFilter(clientResources, "/login");
    }
}
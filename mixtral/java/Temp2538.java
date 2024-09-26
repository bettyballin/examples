import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.DefaultRedirectStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class Temp2538 {

    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    String loginPageUrl;

    public static void main(String[] args) {
        // Entry point
    }

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        handleRedirect(request, response, authentication);
    }

    private void handleRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(request, authentication);
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    private String determineTargetUrl(HttpServletRequest request, Authentication authentication) {
        Collection<?> authorities = authentication.getAuthorities();

        if (authorities.contains("ROLE_ADMIN")) {
            return loginPageUrl;
        }

        // Additional logic...

        return "/";
    }
}
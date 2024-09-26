import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {

        String targetUrl = null;

        SecurityContext securityContext = SecurityContextHolder.getContext();

        Collection<? extends GrantedAuthority> authorities = securityContext.getAuthentication().getAuthorities();

        if (authorities.stream().anyMatch(authority -> "ROLE_NEEDS_EMAIL_AUTH".equals(authority.getAuthority()))) {
            targetUrl = "/authenticate";
        } else if (authorities.stream().anyMatch(authority -> "ROLE_AUTHORIZED_USER".equals(authority.getAuthority()))) {
            targetUrl = "/authorized_user_url";
        } else {
            targetUrl = super.determineTargetUrl(request, response);
        }

        return targetUrl;
    }
}
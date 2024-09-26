import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserDetailsPopulator extends HandlerInterceptorAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    // This method is called before the controller's handler
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String username = getUsernameFromTokenOrHeader(request);

        if (username != null && !isAuthenticated()) {
            UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(username, "");

            Authentication auth = authenticationManager.authenticate(authReq);

            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        return true;
    }

    private String getUsernameFromTokenOrHeader(HttpServletRequest request) {
        // Implement this method to extract the username from a token or header
        // For example, you can get it from a header like this:
        // return request.getHeader("X-Username");

        // Placeholder return statement
        return null;
    }

    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || 
            authentication instanceof AbstractPreAuthenticatedProcessingFilter) {
            return false;
        }

        return true;
    }
}
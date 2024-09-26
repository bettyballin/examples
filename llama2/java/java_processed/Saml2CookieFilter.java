import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.saml2.provider.service.authentication.Saml2Authentication;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Saml2CookieFilter extends OncePerRequestFilter {

    private static final String FIRST_TIME_ATTRIBUTE = "firstTimeAttribute";
    private static final Cookie customCookie = new Cookie("customCookie", "customValue");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        // Check if the current authentication is a SAML2 authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof Saml2Authentication)) {
            filterChain.doFilter(request, response);
            return;
        }

        // Check if this is the first time the filter is called for this request
        Boolean firstTime = (Boolean) request.getAttribute(FIRST_TIME_ATTRIBUTE);
        if (firstTime == null) {
            request.setAttribute(FIRST_TIME_ATTRIBUTE, true);
        } else if (!firstTime) {
            filterChain.doFilter(request, response);
            return;
        }

        // Set the custom cookie
        response.addCookie(customCookie);

        // Mark this filter as called for this request
        request.setAttribute(FIRST_TIME_ATTRIBUTE, false);

        // Continue the filter chain
        filterChain.doFilter(request, response);
    }
}
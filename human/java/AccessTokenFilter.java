import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Optional;
import javax.inject.Inject;

/**
 * Access token filter for the chat websocket. Requests without a valid access token 
 * are refused with a <code>403</code>.
 *
 */
@WebFilter("/chat/*")
public class AccessTokenFilter implements Filter {

    @Inject
    private Authenticator authenticator;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, 
            FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // Extract access token from the request
        String token = request.getParameter("access-token");
        if (token == null || token.trim().isEmpty()) {
            returnForbiddenError(response, "An access token is required to connect");
            return;
        }

        // Validate the token and get the user who the token has been issued for
        Optional<String> optionalUsername = authenticator.getUsernameFromToken(token);
        if (optionalUsername.isPresent()) {
            filterChain.doFilter(
                    new AuthenticatedRequest(
                            request, optionalUsername.get()), servletResponse);
        } else {
            returnForbiddenError(response, "Invalid access token");
        }
    }

    private void returnForbiddenError(HttpServletResponse response, String message) 
            throws IOException {
        response.sendError(HttpServletResponse.SC_FORBIDDEN, message);
    }

    @Override
    public void destroy() {

    }

    /**
     * Wrapper for a {@link HttpServletRequest} which decorates a 
     * {@link HttpServletRequest} by adding a {@link Principal} to it.
     *
     */
    private static class AuthenticatedRequest extends HttpServletRequestWrapper {

        private String username;

        public AuthenticatedRequest(HttpServletRequest request, String username) {
            super(request);
            this.username = username;
        }

        @Override
        public Principal getUserPrincipal() {
            return () -> username;
        }
    }
}

interface Authenticator {
    Optional<String> getUsernameFromToken(String token);
}
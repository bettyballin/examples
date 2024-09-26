import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.web.csrf.CsrfToken;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrainingModeCsrfFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(TrainingModeCsrfFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) 
            throws ServletException, IOException {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");

        if (!isMissingOrInvalidCSRFToken(request)) {
            // If the token is present and valid, continue with the request
            filterChain.doFilter(request, response);
        } else {
            log.warn("Missing or invalid CSRF Token found in training mode.");

            // Return a 403 status code
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);

            // Optionally, you could continue with the request but this is not recommended
            // filterChain.doFilter(request, response);
        }
    }

    private boolean isMissingOrInvalidCSRFToken(HttpServletRequest request) {
        CsrfToken token = (CsrfToken) request.getAttribute("_csrf");

        // Check if the token exists and matches
        // Implement your logic here to check if the token is missing or invalid
        return token == null || !token.getToken().equals(request.getParameter("_csrf"));
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Implement if you need any filter-specific initialization
    }

    @Override
    public void destroy() {
        // Implement if you need any filter-specific cleanup
    }
}
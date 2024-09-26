import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final PublicApiRequestMatcher publicApiRequestMatcher;

    @Autowired
    public SecurityFilter(PublicApiRequestMatcher publicApiRequestMatcher) {
        this.publicApiRequestMatcher = publicApiRequestMatcher;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (publicApiRequestMatcher.matches(request)) {
            // If the request matches a public API endpoint skip the SecurityFilter
            filterChain.doFilter(request, response);
        } else {
            // Otherwise continue with the regular SecurityFilter logic
            super.doFilterInternal(request, response, filterChain);
        }
    }
}

interface PublicApiRequestMatcher {
    boolean matches(HttpServletRequest request);
}

// Add a basic implementation for the PublicApiRequestMatcher interface
@Component
class PublicApiRequestMatcherImpl implements PublicApiRequestMatcher {
    @Override
    public boolean matches(HttpServletRequest request) {
        // You can implement your own logic to check if the request matches a public API endpoint
        // For example:
        String uri = request.getRequestURI();
        return uri.startsWith("/public");
    }
}
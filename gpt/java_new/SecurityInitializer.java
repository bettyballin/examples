import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import javax.servlet.ServletContext;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        // Assuming CookieReferrerFilter is defined elsewhere and we are importing it
        insertFilters(servletContext, new CookieReferrerFilter());
    }
}

// Assuming CookieReferrerFilter is defined like this:
class CookieReferrerFilter implements javax.servlet.Filter {
    // Implementation of the Filter methods
    @Override
    public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.FilterChain chain) {
        // Filter logic goes here
    }

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) {
        // Initialization code can be added here
    }

    @Override
    public void destroy() {
        // Cleanup code can be added here
    }
}
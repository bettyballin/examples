import javax.servlet.*;
import java.io.IOException;

public class MyFilter2 implements Filter {
    private Filter firstFilter;
    private Filter secondFilter;
    private Filter thirdFilter;
    private AuthMethod authMethod; // Enum or some class representing auth methods

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // assuming authMethod is set elsewhere
        switch (authMethod) {
            case FIRST:
                firstFilter.doFilter(servletRequest, servletResponse, filterChain);
                break;
            case SECOND:
                secondFilter.doFilter(servletRequest, servletResponse, filterChain);
                break;
            case THIRD:
                thirdFilter.doFilter(servletRequest, servletResponse, filterChain);
                break;
            default:
                throw new ServletException("Unknown authentication method");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialize the filters and authMethod here
    }

    @Override
    public void destroy() {
        // Clean up resources here
    }
    
    // Enum or class definition for AuthMethod, if it doesn't already exist
    enum AuthMethod {
        FIRST, SECOND, THIRD
    }
}
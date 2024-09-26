import javax.servlet.*;
import java.io.IOException;

public class Temp1237 implements Filter {

    private enum AuthMethod {
        FIRST, SECOND, THIRD
    }

    private AuthMethod authMethod = AuthMethod.FIRST; // Example initialization
    private Filter firstFilter = new FirstFilter();
    private Filter secondFilter = new SecondFilter();
    private Filter thirdFilter = new ThirdFilter();

    public static void main(String[] args) {
        // This class is intended to be used as a servlet filter, not to be executed directly.
        // Main method is not applicable here.
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if any
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*some actions to define the right authMethod to use*/
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
    public void destroy() {
        // Cleanup code, if any
    }

    // Dummy filter implementations for demonstration
    private static class FirstFilter implements Filter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {}

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            // FirstFilter logic here
            chain.doFilter(request, response);
        }

        @Override
        public void destroy() {}
    }

    private static class SecondFilter implements Filter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {}

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            // SecondFilter logic here
            chain.doFilter(request, response);
        }

        @Override
        public void destroy() {}
    }

    private static class ThirdFilter implements Filter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {}

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            // ThirdFilter logic here
            chain.doFilter(request, response);
        }

        @Override
        public void destroy() {}
    }
}
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.annotation.WebFilter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

import java.io.IOException;

@WebFilter("/example")
class ExampleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Filter logic here
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}

public class Temp1313 {
    public static void main(String[] args) {
        // Simulating servlet context and adding filter
        ServletContext servletContext = new MockServletContext();
        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("exampleFilter", ExampleFilter.class);
        filterRegistration.addMappingForUrlPatterns(null, false, "/example");
    }
}

// MockServletContext to simulate ServletContext for the example
class MockServletContext implements ServletContext {
    // Implement necessary methods for the example
    @Override
    public FilterRegistration.Dynamic addFilter(String filterName, Class<? extends Filter> filterClass) {
        return new MockFilterRegistration();
    }
    
    // Omitting other methods for brevity
    // Implement other ServletContext methods as no-op or minimal implementations if required

    class MockFilterRegistration implements FilterRegistration.Dynamic {
        @Override
        public void addMappingForUrlPatterns(EnumSet<DispatcherType> dispatcherTypes, boolean isMatchAfter, String... urlPatterns) {
            System.out.println("Filter added with URL pattern: " + Arrays.toString(urlPatterns));
        }

        // Omitting other methods for brevity
        // Implement other FilterRegistration.Dynamic methods as no-op or minimal implementations if required
    }
}
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import org.springframework.web.filter.DelegatingFilterProxy;

public class Temp773 {
    public static void main(String[] args) {
        // Simulate a ServletContext for demonstration purposes
        ServletContext servletContext = new MockServletContext();

        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("mv-security-filter", new DelegatingFilterProxy("springSecurityFilterChain"));
        filterRegistration.addMappingForUrlPatterns(null, false, "/*");
        
        System.out.println("Filter registration completed.");
    }
}

// Mock ServletContext class to allow the code to run without a real servlet container
class MockServletContext implements ServletContext {
    @Override
    public FilterRegistration.Dynamic addFilter(String filterName, javax.servlet.Filter filter) {
        return new MockFilterRegistration();
    }
    
    // Other methods of ServletContext are not implemented for brevity
    // ...
}

// Mock FilterRegistration class to allow the code to run without a real servlet container
class MockFilterRegistration implements FilterRegistration.Dynamic {
    @Override
    public void addMappingForUrlPatterns(EnumSet<DispatcherType> dispatcherTypes, boolean isMatchAfter, String... urlPatterns) {
        System.out.println("Mapping filter to URL patterns: " + String.join(", ", urlPatterns));
    }
    
    // Other methods of FilterRegistration.Dynamic are not implemented for brevity
    // ...
}
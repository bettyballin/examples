import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // Return an empty array since you don't have any root context configuration
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Include your security config here
        return new Class[]{SecurityWebApplicationInitializer.class, SecurityConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // Map the DispatcherServlet to "/"
        return new String[]{"/"};
    }

}

// Assuming you have SecurityWebApplicationInitializer and SecurityConfig classes defined elsewhere
class SecurityWebApplicationInitializer {
    // Implementation details
}

class SecurityConfig {
    // Implementation details
}
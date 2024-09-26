import javax.servlet.ServletContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.WebApplicationInitializer;

public class Temp273 implements WebApplicationInitializer {
    public static void main(String[] args) {
        // This main method is just a placeholder. In a real Spring application,
        // the context would be initialized by the Spring framework.

        // Simulating the servlet context for demonstration
        ServletContext servletContext = null; // Normally provided by the server

        // Initialize the filter chain
        Temp273 temp = new Temp273();
        temp.beforeSpringSecurityFilterChain(servletContext);
    }

    @Override
    public void onStartup(ServletContext servletContext) {
        beforeSpringSecurityFilterChain(servletContext);
    }

    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        if (servletContext != null) {
            servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain")).addMappingForUrlPatterns(null, false, "/*");
        }
    }
}
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.DelegatingFilterProxy;

public class CustomWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(final ServletContext servletContext) throws ServletException {
        DelegatingFilterProxy filter1 = new DelegatingFilterProxy("springSecurityFilterChain");
        filter1.setServletContext(servletContext);
        filter1.setContextAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher");

        DelegatingFilterProxy filter2 = new DelegatingFilterProxy("corsFilter");

        servletContext.addFilter("springSecurityFilterChain", filter1).addMappingForUrlPatterns(null, false, "/*");
        servletContext.addFilter("corsFilter", filter2).addMappingForUrlPatterns(null, false, "/*");
    }
}
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyWebAppInitializer implements javax.servlet.ServletContextListener {

    @Override
    public void contextInitialized(javax.servlet.ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        FilterRegistration.Dynamic securityFilter = servletContext.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
        securityFilter.addMappingForUrlPatterns(null, false, "/*");
    }

    @Override
    public void contextDestroyed(javax.servlet.ServletContextEvent sce) {
        // Do any cleanup here if necessary
    }
}
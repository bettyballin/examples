import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import org.springframework.web.WebApplicationInitializer;

import java.util.EnumSet;

public class MyWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        FilterRegistration.Dynamic monitoringFilter =
                container.addFilter("monitoring", new MonitoringFilter());

        EnumSet<DispatcherType> dispatcherTypes =
                EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);

        monitoringFilter.addMappingForUrlPatterns(dispatcherTypes, true, "/*");
    }
}

@WebFilter("/*")
class MonitoringFilter implements javax.servlet.Filter {
    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
        // Initialization code
    }

    @Override
    public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response,
                         javax.servlet.FilterChain chain) throws java.io.IOException, ServletException {
        // Filtering code
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code
    }
}
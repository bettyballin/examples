import javax.servlet.*;
import javax.servlet.FilterRegistration.Dynamic;
import java.util.EnumSet;

public class MyWebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        FilterRegistration.Dynamic springSecurityFilterChain =
            servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy());

        EnumSet<DispatcherType> dispatchTypes =
                EnumSet.of(DispatcherType.REQUEST, DispatcherType.ERROR);

        springSecurityFilterChain
          .addMappingForUrlPatterns(dispatchTypes, false, "/*");
    }
}

interface WebApplicationInitializer {
    void onStartup(ServletContext servletContext) throws ServletException;
}

class DelegatingFilterProxy implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws java.io.IOException, ServletException {
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
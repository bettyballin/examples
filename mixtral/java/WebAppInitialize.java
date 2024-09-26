import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.DelegatingFilterProxy;
import java.util.EnumSet;

@WebListener
public class WebAppInitialize implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) throws ServletException {
        FilterRegistration.Dynamic springSecurityFilterChain =
                container.addFilter("springSecurityFilterChain", new DelegatingFilterProxy());

        EnumSet<DispatcherType> dispatcherTypes =
                EnumSet.of(DispatcherType.REQUEST, DispatcherType.ERROR);

        springSecurityFilterChain.addMappingForUrlPatterns(dispatcherTypes, false, "/*");
    }
}
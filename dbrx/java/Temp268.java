import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import java.util.EnumSet;

public class Temp268 {

    public void onStartup(ServletContext servletContext) throws ServletException {
        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);

        FilterRegistration.Dynamic securityFilterChain = servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy());
        securityFilterChain.setInitParameter("contextAttribute", "org.springframework.web.context.WebApplicationContext.ROOT");
        securityFilterChain.addMappingForUrlPatterns(dispatcherTypes, true, "/*");

        CharacterEncodingFilter characterEncoding = new CharacterEncodingFilter();
        characterEncoding.setForceEncoding(true);
        characterEncoding.setEncoding("UTF-8");
        FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", characterEncoding);
        characterEncodingFilter.addMappingForUrlPatterns(dispatcherTypes, false, "/*");
    }

    public static void main(String[] args) {
        // Placeholder for main logic if needed
    }
}
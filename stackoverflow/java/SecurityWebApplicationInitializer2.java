import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer2;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class SecurityWebApplicationInitializer2 extends AbstractSecurityWebApplicationInitializer2 implements WebApplicationInitializer {

    public SecurityWebApplicationInitializer2() {
        super(SecurityConfiguration.class);
    }

    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        appContext.setConfigLocation("/WEB-INF/spring-web-servlet.xml");

        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet(appContext));
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
        registration.setMultipartConfig(new MultipartConfigElement("", 1000000, 1000000, 100000));
    }
}
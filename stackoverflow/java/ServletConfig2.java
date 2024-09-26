import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.servlet.Servlet;

@Configuration
public class ServletConfig2 {

    @Bean
    public ServletRegistrationBean<Servlet> dispatcherServlet() {
        ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<>();
        servletRegistrationBean.addUrlMappings("/");
        servletRegistrationBean.setServlet(new DispatcherServlet()); // Assuming DispatcherServlet exists
        return servletRegistrationBean;
    }

    @Bean
    public ServletRegistrationBean<Servlet> springVaadinServlet() {
        ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<>();
        servletRegistrationBean.addUrlMappings("/vaadinServlet/*", "/VAADIN/*");
        servletRegistrationBean.setServlet(new SpringVaadinServlet()); // Assuming SpringVaadinServlet exists
        return servletRegistrationBean;
    }
}
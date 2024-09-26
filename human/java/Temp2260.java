import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

public class Temp2260 extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Temp2260.class, args);
    }

    @Bean
    public ServletRegistrationBean<DispatcherServlet> dispatcherServletRegistration() {
        ServletRegistrationBean<DispatcherServlet> registration = new ServletRegistrationBean<>(new DispatcherServlet(), "/");
        registration.setName("dispatcherServlet");
        return registration;
    }

    @Bean
    public ServletRegistrationBean<SpringVaadinServlet> vaadinServletRegistration() {
        ServletRegistrationBean<SpringVaadinServlet> registration = new ServletRegistrationBean<>(new SpringVaadinServlet(), "/vaadinServlet/*", "/VAADIN/*");
        registration.setName("springVaadinServlet");
        return registration;
    }
}
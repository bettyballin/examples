import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
class HibernateConfig {
    // Configuration details for Hibernate
}

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{HibernateConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null; // No servlet configuration classes
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    public static void main(String[] args) {
        // Assuming a Spring Boot application for demonstration purposes
        org.springframework.boot.SpringApplication.run(MyWebAppInitializer.class, args);
    }
}
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UrlConfig {

    @Bean
    public UrlServiceProperties urlServiceProperties() {
        return new UrlServiceProperties();
    }

    public static class UrlServiceProperties {
        // Add properties and methods as needed
    }

    public static void main(String[] args) {
        // Initialize Spring context to test the configuration
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(UrlConfig.class);
        
        UrlServiceProperties properties = context.getBean(UrlServiceProperties.class);
        System.out.println("Bean initialized: " + (properties != null));
        
        context.close();
    }
}
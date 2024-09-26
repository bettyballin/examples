import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Component;

@Component
public class Temp51 {

    // Autowire the sessionRegistry
    @Autowired
    private SessionRegistry sessionRegistry;

    public static void main(String[] args) {
        // Since we're using Spring, we need to initialize the Spring context
        org.springframework.context.ApplicationContext context =
            new org.springframework.context.annotation.AnnotationConfigApplicationContext(AppConfig.class);

        // Get the Temp51 bean from the Spring context
        Temp51 temp51 = context.getBean(Temp51.class);
    }
}

// Configuration class for Spring context
@Configuration
@ComponentScan(basePackages = "your.package.name")
class AppConfig {
}
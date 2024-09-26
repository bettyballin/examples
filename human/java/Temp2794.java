import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
class ResourceServerContext {
    // Your configuration code here
}

public class Main {
    public static void main(String[] args) {
        // Application entry point.
        // You can initialize the Spring context here if required.
        System.out.println("ResourceServerContext is configured and ready to use.");
    }
}
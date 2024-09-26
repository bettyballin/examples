import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Component;

@Component
public class Temp490 {

    @Autowired
    private SessionRegistry sessionRegistry;

    public static void main(String[] args) {
        // Initialize the Spring context
        org.springframework.context.ApplicationContext context =
                new org.springframework.context.annotation.AnnotationConfigApplicationContext(AppConfig.class);

        // Get the Temp490 bean from the context
        Temp490 temp490 = context.getBean(Temp490.class);

        // Use the sessionRegistry as needed
        System.out.println(temp490.sessionRegistry);
    }
}

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

@Configuration
class AppConfig {

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public Temp490 temp490() {
        return new Temp490();
    }
}
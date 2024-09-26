import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Temp53 {
    public static void main(String[] args) {
        // Simulate the Spring context initialization
        MyConfig config = new MyConfig();
        ApplicationListener<AbstractAuthenticationEvent> listener = config.authenticationListener();
        // Further logic can be added here as needed
    }
}

@Configuration
class MyConfig {
    @Bean
    public ApplicationListener<AbstractAuthenticationEvent> authenticationListener() {
        return new MyAuthenticationListener();
    }
}

class MyAuthenticationListener implements ApplicationListener<AbstractAuthenticationEvent> {
    @Override
    public void onApplicationEvent(AbstractAuthenticationEvent event) {
        // Handle the authentication event here
        System.out.println("Authentication event received: " + event);
    }
}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// Define SecurityUser class
class SecurityUser {
    private String username;
    
    public SecurityUser(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }
}

// Define CustomUserEvent class
class CustomUserEvent extends ApplicationEvent {
    private String username;
    
    public CustomUserEvent(Object source, String username) {
        super(source);
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }
}

// Define MyService class
@Service
public class MyService {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public MyService(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void doSomething(SecurityUser loggedUser) {
        // Perform actions based on the `loggedUser`
        CustomUserEvent event = new CustomUserEvent(this, loggedUser.getUsername());
        applicationEventPublisher.publishEvent(event);
    }
}

// Define a listener for CustomUserEvent
@Component
class CustomUserEventListener implements ApplicationListener<CustomUserEvent> {

    @Override
    public void onApplicationEvent(CustomUserEvent event) {
        System.out.println("Event received for user: " + event.getUsername());
    }
}

// Main application to test the service
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(MyService myService) {
        return (args) -> {
            SecurityUser user = new SecurityUser("john_doe");
            myService.doSomething(user);
        };
    }
}


Note: `SecurityUser` and `CustomUserEvent` should be made public or moved to their own separate files if they are intended to be used outside of the current package. The updated code assumes that they are intended to be package-private. 

Additionally, the code now uses constructor-based injection instead of field-based injection. This is a recommended best practice in Spring, as it makes the code easier to test and provides better support for immutable objects.
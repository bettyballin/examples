Here is the corrected code:


import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// Define the CustomUserEvent class
public class CustomUserEvent extends ApplicationEvent {
    private final String username;

    public CustomUserEvent(Object source, String username) {
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

// Define the MyEventListener class
@Component
public class MyEventListener implements ApplicationListener<CustomUserEvent> {

    @Override
    public void onApplicationEvent(CustomUserEvent event) {
        String username = event.getUsername();
        // Perform actions based on the `username`
        System.out.println("Received event for user: " + username);
    }
}

// Main application to publish event
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ApplicationEventPublisher publisher) {
        return args -> {
            // Publish a sample event
            publisher.publishEvent(new CustomUserEvent(EventDemoApplication.this, "john_doe"));
        };
    }
}

Note: I have made CustomUserEvent class as public and have used EventDemoApplication.this instead of this in the publishEvent method call.
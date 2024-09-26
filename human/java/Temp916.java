import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Component;

@Component
public class Temp916 {

    @Autowired
    private SessionRegistry sessionRegistry;

    public static void main(String[] args) {
        // Spring Boot or Spring Application context is required to auto-wire the dependencies
        // This code needs to run within a Spring Application Context
        System.out.println("Application is running.");
    }
}
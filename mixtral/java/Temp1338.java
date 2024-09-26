import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Temp1338 {

    @Autowired
    private AccessDecisionManager accessDecisionManager;

    public static void main(String[] args) {
        // Spring application context should be initialized here to inject the dependencies
        // This is just a placeholder to demonstrate the use of @Autowired in a Spring context
        System.out.println("Application started.");
    }
}

interface AccessDecisionManager {
    // Define methods for the interface
}
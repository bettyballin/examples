import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;

@Component
public class Temp1527 {

    @Autowired
    private AuthenticationManager authenticationManager;

    public static void main(String[] args) {
        // Assuming a Spring context is initialized here
        // This will not work as a standalone Java application without a Spring context
        // For demonstration purposes only
        System.out.println("Temp1527 class loaded.");
    }
}
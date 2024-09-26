import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class AuthenticationService {
    public boolean authenticate(String username, String password) {
        // Placeholder for actual authentication logic
        return "user".equals(username) && "pass".equals(password);
    }
}

public class Temp780 {
    @Autowired
    private AuthenticationService authenticationService;

    public boolean authenticateUser(String username, String password) {
        return this.authenticationService.authenticate(username, password);
    }

    public static void main(String[] args) {
        // Create an instance of the Spring context
        org.springframework.context.annotation.AnnotationConfigApplicationContext context =
                new org.springframework.context.annotation.AnnotationConfigApplicationContext(Temp780Config.class);
        
        // Get the Temp780 bean from the context
        Temp780 temp780 = context.getBean(Temp780.class);
        
        // Test the authenticateUser method
        boolean isAuthenticated = temp780.authenticateUser("user", "pass");
        System.out.println("Authentication successful: " + isAuthenticated);
        
        context.close();
    }
}

@Configuration
@ComponentScan(basePackages = "your.package.name")
class Temp780Config {
}
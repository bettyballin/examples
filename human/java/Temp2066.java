import java.util.Properties;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class Temp2066 {
    public static void main(String[] args) {
        Properties users = new Properties();
        users.setProperty("user", "password,ROLE_USER");
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(users);
        
        // Example usage
        System.out.println(manager.userExists("user")); // Should print: true
    }
}
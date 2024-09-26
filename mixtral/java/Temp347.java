import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Service;

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Temp347 {
    public static void main(String[] args) {
        // Instantiate the service and call methods for testing
        MyService service = new MyService();
        service.readOnlyMethod();
        service.restrictedUsers("john");
    }
}

@Service
class MyService {

    @PreAuthorize("hasRole('ROLE_READONLY')")
    public void readOnlyMethod() {
        // Your code here
        System.out.println("Read-only method executed.");
    }

    // Or for specific users
    @PreAuthorize("#username != 'bob' and #username != 'alice'")
    public void restrictedUsers(String username) {
        // Your code here
        System.out.println("Restricted user method executed for " + username);
    }
}
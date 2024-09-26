import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Temp1304 {

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("@securityService.isCurrentUser(#userId)")
    public User updateUser(@PathVariable("id") Long userId, @RequestBody User updatedUser) {
        // Implementation
        return updatedUser;
    }

    public static void main(String[] args) {
        // Main method for execution
    }
}

class User {
    // User class implementation
}



// Add the following annotations to the User class
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

// Adding @SpringBootApplication annotation to enable auto-configuration of the Spring Application Context.
@SpringBootApplication
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityService {
    public boolean isCurrentUser(Long userId) {
        // SecurityService implementation
        return true; 
    }
}

// User class
class User {
    // User class implementation
}
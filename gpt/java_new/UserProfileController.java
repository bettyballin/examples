import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

public class UserProfileController {

    @PreAuthorize("hasPermission(#userId, 'User', 'read')")
    public ResponseEntity<?> getUserProfile(Long userId) {
        try {
            // Assuming userService is injected and available here
            User user = userService.getUser(userId);
            // Your business logic here
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            // Exception handling logic here
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    // Assuming User class exists
    class User {
        // User class implementation here
    }
    
    // Assuming UserService is an interface with getUser method
    interface UserService {
        User getUser(Long userId);
    }
    
    // Assume userService is autowired and available here
    private UserService userService;
    
    // Constructor for dependency injection
    public UserProfileController(UserService userService) {
        this.userService = userService;
    }
}
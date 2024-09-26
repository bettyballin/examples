import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController1 {

    @RequestMapping(value = "/user_details")
    public ResponseEntity<?> getUserDetails(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            // Assuming you have a User object with details
            Object principal = authentication.getPrincipal();
            if (principal instanceof User) {
                User user = (User) principal;
                // Create a DTO to send necessary user details
                UserDetailsDTO userDetails = new UserDetailsDTO(user);
                return ResponseEntity.ok(userDetails);
            } else {
                return ResponseEntity.badRequest().body("User details not found.");
            }
        } else {
            return ResponseEntity.status(401).body("User is not authenticated.");
        }
    }

    // Placeholder class definitions
    public static class User { /* ... */ }

    public static class UserDetailsDTO {
        public UserDetailsDTO(User user) {
            // Map user details to DTO fields
        }
    }
}
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController6 {

    @RequestMapping("/login")
    public ResponseEntity<String> login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        // Logic for authentication
        // If successful, return ResponseEntity.ok("Login successful");
        // If not, return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        
        boolean isAuthenticated = authenticate(username, password);

        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }

    private boolean authenticate(String username, String password) {
        // Implement authentication logic here
        return false; // Example implementation
    }
}
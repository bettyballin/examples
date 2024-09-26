import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Admin1Controller {

    @Autowired
    private SecurityUtils securityUtils;

    // Secure this method with a custom SpEL expression

    @GetMapping("/admin1/**")
    @PreAuthorize("@securityUtils.hasRequiredRole(#userId, 'ADMIN1')")
    public ResponseEntity<String> admin1Method(@RequestHeader Long userId) {
        // Your implementation

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

class SecurityUtils {
    public boolean hasRequiredRole(Long userId, String role) {
        // Example implementation
        // Replace with your actual logic to check user roles
        return "ADMIN1".equals(role); // Simplified example
    }
}
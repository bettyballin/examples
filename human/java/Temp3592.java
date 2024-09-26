import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.http.ResponseEntity;

public class Temp3592 {
    public static void main(String[] args) {
        // Spring application context setup would be required to execute this
        // This is just a placeholder to demonstrate the code structure
    }

    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> controllerMethod(@AuthenticationPrincipal CustomObject customObject) {
        // Your implementation here
        return ResponseEntity.ok("Authenticated");
    }
}

class CustomObject {
    // Custom object properties and methods here
}
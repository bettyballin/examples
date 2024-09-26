import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.http.ResponseEntity;

public class YourController11 {

    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> controllerMethod(@AuthenticationPrincipal CustomObject customObject) {
        // Controller logic here
        return ResponseEntity.ok().build();
    }

    // Assuming CustomObject is a valid class in your project
    public static class CustomObject {
        // CustomObject fields and methods
    }
}
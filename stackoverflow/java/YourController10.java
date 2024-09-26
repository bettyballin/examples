import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.ResponseEntity;

public class YourController10 {

    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> controllerMethod(YourOwnAuthentication auth) {
        // Your logic here
        return ResponseEntity.ok().build();
    }
    
    // Assuming YourOwnAuthentication is a custom class you should define
    public class YourOwnAuthentication {
        // Your authentication fields and methods here
    }
}
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/user/resource")
    public ResponseEntity<?> getUserResource() {
        // Your controller logic here
        return ResponseEntity.ok().body("Resource accessed");
    }
}
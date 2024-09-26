import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController7 {

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(Authentication authentication) {
        return ResponseEntity.ok("Welcome [" + authentication.getName() + "]");
    }

    @GetMapping("/loginFailed")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("Failed to login");
    }
}
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

@RestController
public class YourController1 {

    @GetMapping("/your-endpoint")
    public ResponseEntity<?> yourMethod() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String sessionId = null;
        
        if (authentication != null && authentication.getDetails() instanceof WebAuthenticationDetails) {
            sessionId = ((WebAuthenticationDetails) authentication.getDetails()).getSessionId();
        }
        
        // Your logic here using the sessionId

        return ResponseEntity.ok().body("Your response");
    }
}
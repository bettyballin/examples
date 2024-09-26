import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SessionController {

    @GetMapping("/session-refresh-endpoint")
    public ResponseEntity<String> refreshSession(HttpSession session) {
        // No need to do anything here, just accessing the session is enough
        return ResponseEntity.ok("Session refreshed");
    }
}
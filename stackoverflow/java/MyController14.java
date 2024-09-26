import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

@Controller
public class MyController14 {

    @GetMapping("/get-url-here")
    public String main(@AuthenticationPrincipal User user) {
        if (user.getRole().equals("ROLE_ADMIN")) {
            // set values for admin
        } else {
            // set for user
        }
        return "view-or-response-body";
    }
    
    // Assuming User class with getRole method exists
    // This is just a placeholder for the actual implementation
    public class User {
        public String getRole() {
            // Implementation here
            return "ROLE_USER";
        }
    }
}
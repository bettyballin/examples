import org.springframework.security.core.annotation.AuthenticationPrincipal;

// Example usage within a Spring controller
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.UserDetails;

@RestController
public class YourController8 {
    @GetMapping("/user")
    public String getUser(@AuthenticationPrincipal UserDetails user) {
        return "Welcome, " + user.getUsername();
    }
}
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecureController {

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/user-dashboard")
    public String userDashboard() {
        // Method content here
        return "user-dashboard";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin-dashboard")
    public String adminDashboard() {
        // Method content here
        return "admin-dashboard";
    }
}
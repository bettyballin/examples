import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Temp2430 {

    public static void main(String[] args) {
        // Main method content, if needed
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        // Add attributes to model if needed
        return "/registration";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/process_register")
    public String processRegistration() {
        // Process registration logic
        return "redirect:/success";
    }
}
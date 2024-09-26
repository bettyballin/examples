import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/home")
    @PreAuthorize("isAuthenticated()")
    public String home(Model model) {
        // Your logic here
        return "home";
    }
}
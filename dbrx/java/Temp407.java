import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Temp407 {

    public static void main(String[] args) {
        // Main method for execution purposes
    }

    @GetMapping("/myControllerMethod")
    public String myControllerMethod(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && !auth.getPrincipal().equals("anonymousUser")) {
            Object principal = auth.getPrincipal();
            // Assuming your User object has a getUsername() method
            String username = ((UserDetails) principal).getUsername();
            model.addAttribute("username", username);
        }
        return "viewName"; // Replace with your view name
    }
}
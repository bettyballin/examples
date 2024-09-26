// Assuming there's a class-level annotation for the controller and a userService bean available
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class SomeController5 {

    private final UserService userService;

    public SomeController5(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/somePage")
    public String getSomePage(Model model, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        if (principal != null) {
            // User activeUser = userService.getUserByPhone(principal.getName());
            // model.addAttribute("user", activeUser);
            // ... additional logic
            return "somePage"; // Assuming "somePage" is the view's name
        } else {
            System.out.println("User is not authenticated to access somePage.");
            return "redirect:/";
        }
    }
}
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class Temp2302 {

    // Assuming userService is defined and autowired
    private final UserService userService;

    public Temp2302(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/somePage")
    public String getSomePage(Model model, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        if (principal != null) {
            User activeUser = userService.getUserByPhone(principal.getName());
            // ...

        } else { // user is not authenticated
            System.out.println("user is not authenticated to proceed the somePage!!!!!!!");
            return "redirect:/";
        }
        return "somePage"; // Assuming "somePage" is the view to be returned when user is authenticated
    }

    // Assuming UserService and User classes/interfaces are defined elsewhere
    public interface UserService {
        User getUserByPhone(String phone);
    }

    public static class User {
        // User class implementation
    }

    public static void main(String[] args) {
        // Main method implementation
    }
}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

// CustomUserDetailsServiceImpl and CustomUserDetails are assumed to be defined elsewhere in your project

@Controller
public class DemoController {

    private final CustomUserDetailsServiceImpl userService;

    @Autowired
    public DemoController(CustomUserDetailsServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping("/utilisateurs")
    public String getSimpleUserPage(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                if (userDetails instanceof CustomUserDetails) {
                    System.out.println("Email: " + ((CustomUserDetails) userDetails).getEmail());
                }
            }
        }

        return "userPage"; // Assuming you have a view named 'userPage'
    }
}
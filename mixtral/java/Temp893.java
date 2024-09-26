import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Temp893 {
    @GetMapping("/some-logged-in-page")
    public String showUserInfo(@AuthenticationPrincipal CustomUserDetails currentUser, Model model) {
        if (currentUser != null) {
            // Add logged in user details to the model
            model.addAttribute("firstName", currentUser.getFirstName());
            // Add other attributes as needed
            return "some-logged-in-page";
        }
        return "redirect:/login"; // Redirect to login if user is not authenticated
    }
}

class CustomUserDetails {
    private String firstName;
    private String lastName;

    // Constructor, getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
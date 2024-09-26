import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class DefaultController {

    @ModelAttribute
    public void load(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && !"anonymousUser".equalsIgnoreCase(authentication.getName())) {
            CustomUser user = (CustomUser) authentication.getPrincipal();

            // Add the custom user object to your model
            model.addAttribute("user", user);
        }
    }
}

// Assuming you have a CustomUser class defined as follows:
class CustomUser {
    private String username;
    private String email;

    // Constructor, getters, and setters
    public CustomUser(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
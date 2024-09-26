import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.security.Principal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

@ControllerAdvice
public class DefaultControllerAdvice {

    @ModelAttribute
    public void load(ModelMap model, Principal principal) {
        if (principal != null) {
            User customUser = (User) ((Authentication) principal).getPrincipal();
            model.addAttribute("user", customUser);
        }
    }

}
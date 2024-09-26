import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class DefaultController {

    @ModelAttribute
    public void load(ModelMap model, @AuthenticationPrincipal CustomUser user) {
        // Your code here
    }

}

// Assuming CustomUser is a valid class
class CustomUser {
    // Your CustomUser implementation here
}
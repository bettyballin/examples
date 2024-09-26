import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.security.core.Authentication;

@ControllerAdvice
public class SecurityControllerAdvice {

    @ModelAttribute("currentUser")
    public Authentication getCurrentUser(Authentication authentication) {
        return authentication;
    }
}
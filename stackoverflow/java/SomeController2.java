import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.userdetails.User;

public class SomeController2 {
    public ModelAndView someRequestHandler(@AuthenticationPrincipal User activeUser) {
        // ...
        return new ModelAndView();
    }
}
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.userdetails.User;

@Controller
public class Temp333 {
    public static void main(String[] args) {
        // Main method can be used to start the application if needed
    }

    @RequestMapping("/someRequest")
    public ModelAndView someRequestHandler(@AuthenticationPrincipal User activeUser) {
        // Logic for handling the request
        ModelAndView modelAndView = new ModelAndView("someView");
        modelAndView.addObject("username", activeUser.getUsername());
        return modelAndView;
    }
}
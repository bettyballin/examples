import org.springframework.web.bind.annotation.ModelAndView;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SomeController1 {
    
    @RequestMapping("/somePath")
    public ModelAndView someRequestHandler(@AuthenticationPrincipal org.springframework.security.core.userdetails.User activeUser) {
        // ...
        return new ModelAndView("viewName");
    }
}
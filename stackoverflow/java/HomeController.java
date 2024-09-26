import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    // Assuming RequestMappings is a valid class that has a UI constant.
    @RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, path = "/")
    public String home() {
        return "redirect:" + RequestMappings.UI;
    }
}

// Placeholder for the RequestMappings class with UI constant
class RequestMappings {
    public static final String UI = "/ui";
}
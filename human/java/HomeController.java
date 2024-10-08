import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, path = "/")
    public String home() {
        return "redirect:" + RequestMappings.UI;
    }
}

class RequestMappings {
    public static final String UI = "/ui"; // Example URL, set accordingly
}
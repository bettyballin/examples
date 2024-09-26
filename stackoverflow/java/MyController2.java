import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MyController2 {

    @RequestMapping("/403")
    public String accessDenied() {
        return "errors/403";
    }
}
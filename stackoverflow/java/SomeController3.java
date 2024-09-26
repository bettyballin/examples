import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SomeController3 {

    @RequestMapping(value = "/something", headers = "content-type=text/plain")
    public void handleRequest() {
        // Method implementation
    }
}
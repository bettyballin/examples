import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
public class Temp2051 {
    public static void main(String[] args) {
        // Spring Boot application would be required to run this properly
        // This main method is just a placeholder
    }

    @RequestMapping(value = "/security", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(@RequestParam String username, @RequestParam String password) {
        // Handle login logic here
        return "loginSuccess";
    }
}
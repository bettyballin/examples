import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController6 {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin() {
        // Method body
        return "dashboard"; // example view name to return after login
    }
}
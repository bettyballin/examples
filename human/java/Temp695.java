import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
public class Temp695 {
    public static void main(String[] args) {
        SpringApplication.run(Temp695.class, args);
    }
}

@Controller
class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin() {
        return "forward:/authenticate";
    }
}
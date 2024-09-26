import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserController4 {

    @GetMapping(value={"/user", "/user.html"})
    public String user() {
        return "user";
    }
}
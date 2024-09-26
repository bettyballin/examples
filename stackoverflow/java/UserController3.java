import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController3 {
    
    @GetMapping("/user*")
    public String user() {
        return "/user";
    }
}
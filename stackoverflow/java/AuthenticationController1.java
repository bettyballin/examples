import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController1 {

    @RequestMapping(value = "/is_auth")
    public boolean getAuth() {
        return true;
    }
}
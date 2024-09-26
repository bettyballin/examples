import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
public class MyController5 {

    @RequestMapping(value = "/test", method = RequestMethod.GET, headers = "Accept=application/json")
    public HashMap<String, Object> getUser() {
        // Implementation here
        return new HashMap<>();
    }
}
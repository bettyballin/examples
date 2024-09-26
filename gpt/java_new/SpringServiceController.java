import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.HashMap;

@RestController
@RequestMapping("/service/user")
public class SpringServiceController {

    private final HashMap<String, Object> userService = new HashMap<>();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public HashMap<String, Object> getUser(@PathVariable int id) {
        userService.put("name", "hello");
        return userService;
    }
}
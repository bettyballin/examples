import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Collections;
import java.util.Map;

@Controller
public class HelloController {

    @GetMapping(path = "/hello", produces = "application/json")
    @ResponseBody
    public Map<String, String> printHello() {
        return Collections.singletonMap("message", "Hello World");
    }

}
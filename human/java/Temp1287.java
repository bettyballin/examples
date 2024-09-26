import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Temp1287Application {
    public static void main(String[] args) {
        SpringApplication.run(Temp1287Application.class, args);
    }
}

@RestController
@RequestMapping("/api")
class Temp1287Controller {

    @GetMapping(produces = "application/json")
    public @ResponseBody Map<String, String> printHello() {
        Map<String, String> json = new HashMap<>();
        json.put("name", "abcd");
        return json;
    }
}
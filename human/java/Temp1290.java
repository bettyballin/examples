import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@SpringBootApplication
public class Temp1290 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1290.class, args);
    }
}

@RestController
@RequestMapping("/test")
class MyController {

    @GetMapping(produces = "application/json")
    public HashMap<String, String> getUser() {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "Hello World");
        return response;
    }
}
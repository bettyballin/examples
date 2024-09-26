import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@SpringBootApplication
public class Temp3680 {
    public static void main(String[] args) {
        SpringApplication.run(Temp3680.class, args);
    }
}

@RestController
@RequestMapping("/api")
class MyController {
    @GetMapping(value = "/showUserString", produces = MediaType.APPLICATION_JSON_VALUE)
    public String showUserString() {
        return "{\"message\":\"Hello, User!\"}";
    }
}
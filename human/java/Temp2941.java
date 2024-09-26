import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp2941 {
    public static void main(String[] args) {
        SpringApplication.run(Temp2941.class, args);
    }
}

@RestController
class GreetingController {
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/greeting")
    public String greeting() {
        return "works!";
    }
}
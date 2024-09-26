import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp2402 {
    public static void main(String[] args) {
        SpringApplication.run(Temp2402.class, args);
    }
}

@RestController
class UserController {
    @GetMapping(value={"/user", "/user.html"})
    public String user() {
        return "/user";
    }
}
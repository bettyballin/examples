import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp2401 {
    public static void main(String[] args) {
        SpringApplication.run(Temp2401.class, args);
    }

    @RestController
    public static class UserController {
        @GetMapping("/user*")
        public String user() {
            return "/user";
        }
    }
}
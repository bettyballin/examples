import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Temp81 {

    public static void main(String[] args) {
        SpringApplication.run(Temp81.class, args);
    }

    @GetMapping("/users")
    public String getUsers(HttpServletRequest request) {
        // Check if js
        return "User list";
    }
}
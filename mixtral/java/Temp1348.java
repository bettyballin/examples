import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Temp1348 {
    public static void main(String[] args) {
        // Spring Boot application startup logic would be here
        // Since we're focusing on making the class executable, main won't do anything
    }

    @PostMapping("/login")
    public String login() {
        // Handle authentication logic here
        return "Login successful";
    }
}
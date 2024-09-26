import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@RestController
class TestController {

    @GetMapping("/test")
    public String getTest() {
        return "You did it!";
    }

    @GetMapping("/")
    public String getRoot() {
        return "<a href=\"/test\">Go to test</a>";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "<form action=\"/login\" method=\"POST\"><input name=\"username\" /><input name=\"password\" /><input type=\"submit\" /></form>";
    }
}
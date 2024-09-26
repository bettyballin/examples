import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class DemoApp {
    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class, args);
    }
}

@RestController
@RequestMapping("/tolldata")
class TollUsageController {

    @GetMapping
    public String getTollData() {
        return "This is toll data";
    }

    // ... rest of your code

}
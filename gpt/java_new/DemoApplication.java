import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

@RestController
@RequestMapping("/tolldata")
class TollController {

    @GetMapping
    public List<TollUsage> getTollData() {
        // Assuming TollUsage class and the logic to create and return the list exist
        return null; // Replace with actual logic to return list
    }
}

// Assuming this is a placeholder for an actual class definition
class TollUsage {
    // Define properties, constructors, getters, and setters
}
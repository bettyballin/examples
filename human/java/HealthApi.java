import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HealthApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthApiApplication.class, args);
    }

}

@RestController
class HealthApi {

    @GetMapping("/health")
    public String health() {
        return "healthy";
    }

}
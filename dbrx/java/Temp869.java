import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/csp-report")
public class Temp869 {

    public static void main(String[] args) {
        SpringApplication.run(Temp869.class, args);
    }

    @PostMapping(consumes = "application/csp-report")
    public ResponseEntity<String> handleCSPReport(@RequestBody String report) {
        // Your logic here
        return ResponseEntity.ok("Report received");
    }
}
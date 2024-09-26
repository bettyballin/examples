import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}

@RestController
class MyController {
    @GetMapping("/api/my-endpoint")
    @CrossOrigin(origins = "https://example.com", allowedHeaders = "*")
    public ResponseEntity<String> getMyEndpoint() {
        // Your code here
        return ResponseEntity.ok("Hello, World!");
    }
}
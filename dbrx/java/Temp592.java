import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Temp592 {

    public static void main(String[] args) {
        SpringApplication.run(Temp592.class, args);
    }

    @RequestMapping(value = "/mutual-ssl-url", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_MUTUAL_SSL')")
    public ResponseEntity<String> getMutualSslUrl() {
        // Your code here.
        return ResponseEntity.ok("Access granted to mutual SSL URL");
    }
}
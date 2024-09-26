import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp3543Application {
    public static void main(String[] args) {
        SpringApplication.run(Temp3543Application.class, args);
    }
}

@RestController
@RequestMapping("/api")
class Temp3543Controller {

    @PreAuthorize("hasRole('ROLE_ADMIN_3')")
    @GetMapping("/test")
    public ResponseEntity<String> test1() {
        return new ResponseEntity<>("Test", HttpStatus.OK);
    }
}
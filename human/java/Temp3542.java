import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp3542Application {

    public static void main(String[] args) {
        SpringApplication.run(Temp3542Application.class, args);
    }
}

@RestController
class Temp3542Controller {

    @PreAuthorize("hasAuthority('FinanceHead') or hasAuthority('FinanceAdmin') or hasAuthority('Finance3') or hasAuthority('Finance2') or hasAuthority('Finance1')")
    @GetMapping("/test")
    public ResponseEntity<String> test1() {
        return new ResponseEntity<>("Test", HttpStatus.OK);
    }
}
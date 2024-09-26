import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp1259 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1259.class, args);
    }
}

@RestController
class ReportController {

    @PostMapping("/report")
    public ResponseEntity<Void> handleCSPReport(@RequestBody CSPReport cspReport) {
        // Handle the report

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

class CSPReport {
    // Define fields, constructors, getters, and setters here
}
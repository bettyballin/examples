import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Temp1070 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1070.class, args);
    }

    @GetMapping("/reports")
    @PreAuthorize("hasRole('USER') and #userId == principal.id")
    public List<Report> getReports(@RequestParam Long userId) {
        // ...
        return null; // Placeholder for actual implementation
    }
}

class Report {
    // Define Report class properties and methods here
}
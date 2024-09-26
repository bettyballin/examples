import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class Temp1247 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1247.class, args);
    }

    @GetMapping(path = "/licenses")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllLicenses(
            @RequestParam("after") int pagenumber,
            @RequestParam("size") int pagesize,
            @RequestParam("searchText") String searchText) {
        return ResponseEntity.ok("Licenses fetched successfully");
    }
}
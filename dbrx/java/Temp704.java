import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Controller
public class Temp704 {

    public static void main(String[] args) {
        SpringApplication.run(Temp704.class, args);
    }

    @PostMapping("/delete/{photoId}")
    public ResponseEntity<String> deletePhoto(@PathVariable Long photoId, 
                                              @RequestParam(name = "_csrf") String csrfToken) {
        // Validate CSRF token and resource ownership here...
        return ResponseEntity.ok("Photo deleted successfully");
    }
}
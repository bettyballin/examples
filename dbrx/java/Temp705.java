import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class Temp705 {

    @PostMapping("/delete/{photoId}")
    public ResponseEntity<String> deletePhoto(@PathVariable Long photoId, @RequestParam(name = "_csrf") String csrfToken) {
        if (!isValidPhotoId(photoId)) { 
            return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
        }
        
        // Validate CSRF token and resource ownership here...
        
        // Assuming validation success
        return new ResponseEntity<>("Photo deleted successfully", HttpStatus.OK);
    }

    private boolean isValidPhotoId(Long photoId) {
        return photoId != null && photoId > 0;
    }

    public static void main(String[] args) {
        SpringApplication.run(Temp705.class, args);
    }
}
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Temp137 {

    public static void main(String[] args) {
        SpringApplication.run(Temp137.class, args);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("pic") MultipartFile pic, @RequestParam("token") String token) {
        // ...
        return ResponseEntity.ok("File uploaded successfully!");
    }
}
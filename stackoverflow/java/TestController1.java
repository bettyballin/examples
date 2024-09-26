import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController1 {

    @PreAuthorize("hasRole('ROLE_ADMIN_3')")
    @GetMapping("/test")
    public ResponseEntity<String> test1() {
        return new ResponseEntity<>("Test", HttpStatus.OK);
    }
}
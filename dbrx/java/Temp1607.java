import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp1607Application {
    public static void main(String[] args) {
        SpringApplication.run(Temp1607Application.class, args);
    }
}

@RestController
@RequestMapping("/api")
class ExampleController {

    @GetMapping("/example")
    public ResponseEntity<Object> getData() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            // return admin data here
            return ResponseEntity.ok("Admin data");
        } else {
            // return user data here
            return ResponseEntity.ok("User data");
        }
    }
}
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Temp1264 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1264.class, args);
    }
}

@RestController
@RequestMapping("/api")
class MyController {

    @GetMapping("/protected")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String protectedEndpoint() {
        return "This is a protected endpoint";
    }
}
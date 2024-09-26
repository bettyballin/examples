import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class Temp633 {
    public static void main(String[] args) {
        SpringApplication.run(Temp633.class, args);
    }
}

@RestController
class EmailController {

    @GetMapping("/email")
    @PreAuthorize("#oauth2.hasScope('read')")
    public String email() {
        return "test@example.com";
    }
}
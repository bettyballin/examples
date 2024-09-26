import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Temp142 {
    public static void main(String[] args) {
        SpringApplication.run(Temp142.class, args);
    }
}

@RestController
@RequestMapping("/api")
class ApiController {

    @GetMapping("/public")
    @PreAuthorize("permitAll()")
    public String publicEndpoint() {
        return "public";
    }
}
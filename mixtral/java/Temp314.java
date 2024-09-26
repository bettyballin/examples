import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class Temp314Application {

    public static void main(String[] args) {
        SpringApplication.run(Temp314Application.class, args);
    }
}

@Controller
class Temp314Controller {

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_USER')")
    public String admin(Model model) {
        // Your logic here
        return "admin";
    }
}
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController8 {

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String forUser() {
        return "Hello User";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String forAdmin() {
        return "Hello Admin";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'DBA')")
    @GetMapping("/db")
    public String forDb() {
        return "Hello DBA";
    }
}
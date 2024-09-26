import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Temp1411 {
    public static void main(String[] args) {
        // Main method body can be empty as the execution will be handled by Spring Boot
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @RequestMapping(value = "/doblahblah")
    public String doBlahBlah() {
        methodOnlyAdminCanExecute();
        methodOnlyUserCanExecute();
        return "doneBlahBlah";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/douserstuff")
    public String doUserStuff() {
        methodOnlyAdminCanExecute();
        methodOnlyUserCanExecute();
        return "doneUserStuff";
    }

    public void methodOnlyAdminCanExecute() {
        // Implementation for admin only method
    }

    public void methodOnlyUserCanExecute() {
        // Implementation for user only method
    }
}
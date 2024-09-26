import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Temp247 {

    public static void main(String[] args) {
        // Spring Boot application would be started here in a real-world scenario
    }

    @RequestMapping(value = "/boards/{id}")
    @PreAuthorize("hasPermission(#id, 'board', 'read')")
    public String viewBoard(@PathVariable(value = "id") Long id) {
        // Your implementation here.
        return "Viewing board with ID: " + id;
    }
}
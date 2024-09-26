import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubordinateController {

    @PreAuthorize("hasPermission(#id, 'Subordinate', 'view')")
    @GetMapping("/subordinate/{id}")
    public Subordinate getSubordinateDetail(@PathVariable("id") Long id) {
        // Your business logic to return subordinate details
        return new Subordinate(); // Dummy return, replace with actual business logic
    }
}

// Assuming Subordinate is a class you have in your application
class Subordinate {
    // Subordinate properties and methods
}
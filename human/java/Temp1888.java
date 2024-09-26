import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Temp1888 {
    
    @PostMapping("/user/{id}")
    @PreAuthorize("hasRole('ADMIN') || (principal.id == #id)")
    public User updateUser(@RequestBody User newInfo, @PathVariable Long id) {
        // Implement the method logic here
        return new User(); // Dummy return for compilation
    }

    public static void main(String[] args) {
        // Spring Boot application would typically be run here
    }
}

class User {
    // Assume appropriate fields, constructors, getters, and setters are here
}
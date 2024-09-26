import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
public class Temp3025 {

    @GetMapping("/doSomething")
    public ResponseEntity<?> doSomething(@AuthenticationPrincipal(expression = "@userService.getUser(#this)") User user) {
        // Your logic here
        return ResponseEntity.ok().build();
    }

    public static void main(String[] args) {
        // Spring Boot application requires this method to be empty in this context.
    }
}

// Assuming User is a class in your project
class User {
    // User properties and methods
}

// Assuming UserService is a class in your project
class UserService {
    public User getUser(Object principal) {
        // Your logic to get User from principal
        return new User();
    }
}
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Temp1845 {

    @GetMapping("/test")
    public User test(@CurrentUser User current) {
        // ...
        return current; // Assuming you want to return the current user
    }

    public static void main(String[] args) {
        SpringApplication.run(Temp1845.class, args);
    }
}

class User {
    // User class implementation
}

// Dummy annotation for @CurrentUser
@interface CurrentUser {
}
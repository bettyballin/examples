import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PreAuthorize("#authenticatingUser.id == #id or hasRole('ROLE_ADMIN')")
    public User newPassword(@PathVariable int id, @RequestParam String newPassword, @ModelAttribute User authenticatingUser) {
        // Method body goes here
        return null; // Placeholder return statement
    }
}

class User {
    public int id;
    // User class implementation goes here
}
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class Temp986 {

    public static void main(String[] args) {
        // Spring Boot application entry point, usually in a different class with @SpringBootApplication annotation
    }

    @PreAuthorize("#authenticatingUser.id == #id or hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/user/{id}/newPassword", method = RequestMethod.POST)
    public User newPassword(@PathVariable int id, @RequestParam String newPassword, @ModelAttribute User authenticatingUser) {
        // Implement the method to change the password here
        return null; // Placeholder return
    }
}

// Placeholder User class for demonstration purposes
class User {
    int id;
    String password;

    // Getters and setters for 'id' and 'password'
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
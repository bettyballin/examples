import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class Temp2916 {

    public static void main(String[] args) {
        // Main method implementation if needed
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("#updatedUser.userId == principal.userId")
    public User updateUser(@PathVariable("id") Long userId, @RequestBody User updatedUser) {
        // Method implementation here
        return updatedUser; // Assuming the updated user is returned
    }

}

class User {
    public Long userId;
    // Other fields, getters, setters, etc.
}
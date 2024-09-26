import java.util.List;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;

public class Temp71 {

    // Dummy User class for illustration
    static class User {
        Long id;
        String username;

        public User(Long id, String username) {
            this.id = id;
            this.username = username;
        }

        public Long getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }
    }

    public static void main(String[] args) {
        // Main method logic, if any
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public User getUser(@PathVariable Long id) {
        // Your logic to retrieve the user, here returning a dummy user for illustration
        return new User(id, "adminUser");
    }

    // Add a new method for non-admin users
    @PostFilter("filterObject.username == principal.username and hasRole('ROLE_USER')")
    public List<User> findUsers() {
        return getAllUsers();
    }

    // Dummy method to simulate getting all users
    public List<User> getAllUsers() {
        return List.of(
                new User(1L, "user1"),
                new User(2L, "user2"),
                new User(3L, "adminUser")
        );
    }
}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Temp999 {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users/{username}/roles")
    public ResponseEntity<User> addRolesToUser(@PathVariable String username, @RequestBody List<String> roleNames) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Add roleNames to the user (assuming user has a method to add roles)
        user.addRoles(roleNames);
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

// Assuming UserRepository and User are defined as follows:

interface UserRepository {
    User findByUsername(String username);
    void save(User user);
}

class User {
    private String username;
    private List<String> roles;

    public User(String username) {
        this.username = username;
    }

    public void addRoles(List<String> roleNames) {
        this.roles.addAll(roleNames);
    }

    public String getUsername() {
        return username;
    }

    public List<String> getRoles() {
        return roles;
    }
}
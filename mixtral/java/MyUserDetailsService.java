import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    // Assuming you have a User repository or service to fetch user details
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // Implementation here...
        return null;
    }

    public Optional<User> getUserById(Long userId) {
        // Fetch the user by ID from the repository
        return userRepository.findById(userId);
    }

    public boolean userExists(Long userId) throws Exception {
        return getUserById(userId).isPresent();
    }
}

@RestController
public class MyController {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @PreAuthorize("@myUserDetailsService.userExists(#userId)")
    @RequestMapping(value = "/myEndpoint/{userId}", method = RequestMethod.GET)
    public ResponseEntity<MyResponse> myEndpoint(@PathVariable Long userId) throws Exception {
        // Your existing code
        return ResponseEntity.ok(new MyResponse("User exists!"));
    }
}

// Assuming you have a User class and a UserRepository
class User {
    // User fields and methods
}

interface UserRepository {
    Optional<User> findById(Long userId);
}

class MyResponse {
    private String message;

    public MyResponse(String message) {
        this.message = message;
    }

    // Getters and setters
}
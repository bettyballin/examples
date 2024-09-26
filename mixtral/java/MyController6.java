import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin/users")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission(#user, 'WRITE')")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}

// Assuming User is a simple POJO
class User {
    private Long id;
    private String name;

    // getters and setters
}

// UserService is a service to get users
class UserService {
    public List<User> getAllUsers() {
        // return a list of users
        return List.of(new User());
    }
}
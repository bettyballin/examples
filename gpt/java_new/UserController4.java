import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController4 {

    private final UserService userService;

    public UserController4(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or #userId == authentication.principal.id")
    @PostMapping("/user/{id}/edit")
    public boolean editUser(@PathVariable("id") long userId,
                            @RequestBody User newUserObj,
                            @AuthenticationPrincipal User authUser) {
        return userService.edit(userId, newUserObj);
    }
}

class User {
    // User class definition
}

class UserService {
    public boolean edit(long userId, User newUserObj) {
        // UserService edit method implementation
        return false;
    }
}
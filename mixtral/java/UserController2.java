import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/{id}/edit")
    @PreAuthorize("hasRole('ROLE_ADMIN') or #authUser.getId() == #userId")
    public boolean editUser(@PathVariable("id") long userId,
                            @RequestBody User newUserObj,
                            @CurrentUser AuthUser authUser) {
        return userService.edit(userId, newUserObj);
    }

}

// Assuming UserService, User, and AuthUser classes are defined elsewhere
import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;

public class UserService1 {

    @PreAuthorize("hasRole('list_users_permission')")
    public List<UserDto> getAllUsers() {
        return doGetAllUsers();
    }

    private List<UserDto> doGetAllUsers() {
        // ...
        return new ArrayList<>(); // Placeholder for actual implementation
    }
}

class UserDto {
    // User data transfer object fields and methods
}
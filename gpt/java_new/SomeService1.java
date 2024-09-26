import org.springframework.security.access.prepost.PreAuthorize;

public class SomeService1 {

    @PreAuthorize("hasAuthority('ROLE_USER')")
    public void updateUser(User user) {
        // ... update user ...
    }

    @PreAuthorize("hasAuthority('ROLE_READONLY')")
    public User getUser(Long userId) {
        // ... get user ...
        return new User(); // replace with actual user retrieval logic
    }
}
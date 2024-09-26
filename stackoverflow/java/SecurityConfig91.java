import org.springframework.security.access.prepost.PreAuthorize;

public class SecurityConfig91 {

    @PreAuthorize("hasRole('ROLE_ADMIN') or #authUser.id == #userId")
    public void someMethod(Object authUser, Long userId) {
        // method implementation
    }
}
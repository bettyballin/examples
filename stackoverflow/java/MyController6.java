import org.springframework.security.access.prepost.PreAuthorize;

public class MyController6 {

    @PreAuthorize("hasRole('ROLE_ADMIN') or @mySecurityService.isPostOwner(#post_id, principal?.id)")
    public void someMethod(Long post_id) {
        // method implementation
    }
}
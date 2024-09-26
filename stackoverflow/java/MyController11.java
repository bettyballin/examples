import org.springframework.security.access.prepost.PreAuthorize;

public class MyController11 {

    @PreAuthorize("hasRole('ROLE_VIEWER') or hasRole('ROLE_EDITOR') or #id == authentication.principal.username")
    public void myMethod(String id) {
        // method implementation
    }
}
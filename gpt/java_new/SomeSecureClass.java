import org.springframework.security.access.prepost.PreAuthorize;

public class SomeSecureClass {

    @PreAuthorize("hasPermission(#object, 'somePermission')")
    public void secureMethod(Object object) {
        // Method implementation
    }
}
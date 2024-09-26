import org.springframework.security.access.prepost.PreAuthorize;

// ... other imports

public class YourController4 {

    // ... other methods and configurations

    @PreAuthorize("hasRole('ADMIN') and hasRole('EMPLOYEE')")
    public String yourSecuredMethod() {
        // ... your method implementation
        return "secured";
    }
}
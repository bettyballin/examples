import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MyService3 {

    @PreAuthorize("hasAuthority('READ')")
    public void findOne(Long id) {
        // ...
    }

    public void secureMethod() {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        SecurityContextHolder.setContext(context);
        try {
            context.setAuthentication(createServiceAccountAuthentication());
            findOne(1L); // Example call to the secure method
        } finally {
            SecurityContextHolder.clearContext();
        }
    }
    
    // Stub method for createServiceAccountAuthentication
    private Authentication createServiceAccountAuthentication() {
        // Implementation details...
        return null;
    }
}
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class SecurityService4 {

    @PreAuthorize("#clientId == authentication.principal.clientId")
    public Entity findEntity(Long entityId, Long clientId) {
        // your repository call
        return null; // replace with actual repository call
    }

    public MyUserDetails getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof MyUserDetails) {
            return (MyUserDetails) authentication.getPrincipal();
        }
        return null;
    }
}

class Entity {
    // Entity implementation
}

class MyUserDetails {
    // MyUserDetails implementation
    public Long getClientId() {
        // implementation details
        return null;
    }
}
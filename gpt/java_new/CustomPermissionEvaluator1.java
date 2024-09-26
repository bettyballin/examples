import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class CustomPermissionEvaluator1 implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        // Custom permission evaluation logic
        return false; // Replace with actual permission check logic
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        // Custom permission evaluation logic for targetId
        return false; // Replace with actual permission check logic
    }
}

class ProfileArgument {
    private String name;
    // Assume getters and setters are present
}

class ProfileService {

    @PreAuthorize("hasRole('ROLE_USER') and #argument.name == principal.username")
    public void updateProfile(ProfileArgument argument) {
        // Update profile logic
    }
}
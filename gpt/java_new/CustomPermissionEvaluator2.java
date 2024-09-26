import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import java.io.Serializable;

public class CustomPermissionEvaluator2 implements PermissionEvaluator {

    @Autowired
    private YourPermissionService permissionService; // Replace with your actual service class

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        // Implement your logic here
        return permissionService.hasPermission(authentication, targetDomainObject, permission);
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        // Implement your logic here
        return permissionService.hasPermission(authentication, targetId, targetType, permission);
    }
}
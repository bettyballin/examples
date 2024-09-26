import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private OperationService operationService;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        // Implement your permission logic here
        return true; // Placeholder for actual permission check logic
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        // Implement your permission logic here
        return true; // Placeholder for actual permission check logic
    }
}

interface OperationService {
    // Define the methods you need for checking operations
}

class YourService {

    @PreAuthorize("hasPermission(#id, 'yourServiceMethod')")
    public void yourServiceMethod(Long id) {
        // business logic
    }
}
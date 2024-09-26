import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

public class CustomAccessDeniedException extends AccessDeniedException {
    private final int statusCode;
    private final String actionName;

    public CustomAccessDeniedException(String msg, int statusCode, String actionName) {
        super(msg);
        this.statusCode = statusCode;
        this.actionName = actionName;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getActionName() {
        return actionName;
    }
}

public class MyPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        // Implementation here
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        // Implementation here
        return false;
    }
}
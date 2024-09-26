import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.core.Authentication;

public class CustomMethodSecurityExpressionRoot extends SecurityExpressionRoot {

    public CustomMethodSecurityExpressionRoot(Authentication authentication) {
        super(authentication);
    }

    @Override
    public boolean hasPermission(Object target, Object permission) {
        // If the user has ROLE_ADMIN, always return true
        if (hasRole("ROLE_ADMIN")) {
            return true;
        }

        // Otherwise, proceed with the standard permission check
        // Your existing permission logic goes here
        // Assuming there is a method in the superclass that handles permission checks
        return super.hasPermission(target, permission);
    }
}
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if (permission.equals("delete")) {
            // Check ownership and account status here.
            if (!isOwner(authentication, targetDomainObject)) {
                throw new NotOwnerException("You can't delete the object because you are not the owner.");
            }
            if (accountIsSuspended(authentication)) {
                throw new AccountSuspendedException("Your account has been suspended. You cannot perform this action.");
            }

            // If ownership and status checks pass, return true.
            return true;
        }

        // Other permissions...
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        // Implement your logic here for evaluating permission based on targetId and targetType.
        return false;
    }

    private boolean isOwner(Authentication authentication, Object targetDomainObject) {
        // Implement your logic here to check if the user owns the object.
        return true; // Placeholder implementation
    }

    private boolean accountIsSuspended(Authentication authentication) {
        // Check whether an account has been suspended or not.
        return false; // Placeholder implementation
    }
}

class NotOwnerException extends RuntimeException {
    public NotOwnerException(String message) {
        super(message);
    }
}

class AccountSuspendedException extends RuntimeException {
    public AccountSuspendedException(String message) {
        super(message);
    }
}
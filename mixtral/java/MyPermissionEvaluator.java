import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class MyPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        // check if user is authorized
        boolean authorized = checkAuthorization(authentication, targetDomainObject, permission);

        if (!authorized) {
            throw new CustomAccessDeniedException("You are not allowed to perform this action", HttpStatus.FORBIDDEN, "updateSync");
        }

        return true;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        // Implement logic if necessary
        return false;
    }

    private boolean checkAuthorization(Authentication authentication, Object targetDomainObject, Object permission) {
        // Placeholder for actual authorization logic
        return true; // Assume always authorized for demonstration
    }

    public class CustomAccessDeniedException extends AccessDeniedException {
        private final HttpStatus httpStatus;
        private final String action;

        public CustomAccessDeniedException(String msg, HttpStatus httpStatus, String action) {
            super(msg);
            this.httpStatus = httpStatus;
            this.action = action;
        }

        public HttpStatus getHttpStatus() {
            return httpStatus;
        }

        public String getAction() {
            return action;
        }
    }
}
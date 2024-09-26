import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthorizationAspect {

    @Before("@annotation(authorized)")
    public void authorize(JoinPoint joinPoint, Authorized authorized) {
        // Check if user is authenticated and has required roles.
        boolean isAuthenticated = checkIfUserIsAuthenticated();
        if (!isAuthenticated) {
            throw new SecurityException("User is not authenticated");
        }
        
        String[] requiredRoles = authorized.roles();

        for (String role : requiredRoles) {
            if (!isRoleAssignedToUser(role)) {
                throw new SecurityException("Access denied");
            }
        }

    }

    private boolean checkIfUserIsAuthenticated() {
        // Dummy implementation for example purposes
        return true; // Replace with actual authentication check
    }

    private boolean isRoleAssignedToUser(String role) {
        // Dummy implementation for example purposes
        return true; // Replace with actual role check
    }
}

// Sample Authorized annotation for completeness
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Authorized {
    String[] roles();
}
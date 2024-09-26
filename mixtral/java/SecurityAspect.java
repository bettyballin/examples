import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.access.AccessDeniedException;

@Aspect
public class SecurityAspect {

    @Around("execution(* *(..)) && @annotation(secure)")
    public Object checkSecurity(ProceedingJoinPoint joinPoint, Secure secure) throws Throwable {
        if (AuthUtils.isAuthenticatedWithRoles(secure.roles()))
            return joinPoint.proceed();

        throw new AccessDeniedException("Access denied");
    }
}

@interface Secure {
    String[] roles();
}

class AuthUtils {
    public static boolean isAuthenticatedWithRoles(String[] roles) {
        // Implement authentication logic here
        return true; // Placeholder implementation
    }
}
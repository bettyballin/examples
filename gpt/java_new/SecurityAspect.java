import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PreAuthorized {
    String value();
}

@Aspect
public class SecurityAspect {

    @Pointcut("@annotation(preAuthorized)")
    public void callAt(PreAuthorized preAuthorized) {
    }

    @Around("callAt(preAuthorized)")
    public Object checkSecurity(ProceedingJoinPoint pjp, PreAuthorized preAuthorized) throws Throwable {
        // Mock security check
        String requiredRole = preAuthorized.value();
        if (!"ROLE_ADMIN".equals(requiredRole)) {
            throw new SecurityException("Unauthorized access");
        }
        return pjp.proceed();
    }
}
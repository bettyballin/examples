import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Secure {
    String[] roles();
}

@Aspect
@Component
public class SecurityAspect1 {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Around("@annotation(secure)")
    public Object checkSecurity(ProceedingJoinPoint joinPoint, Secure secure) throws Throwable {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authenticationManager.hasRoles(authentication, secure.roles())) {
            return joinPoint.proceed();
        } else {
            throw new SecurityException("User does not have the required roles.");
        }
    }
}

interface AuthenticationManager {
    boolean hasRoles(Authentication authentication, String[] roles);
}
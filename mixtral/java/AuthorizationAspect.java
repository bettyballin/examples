import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.List;

@Aspect
@Component
public class AuthorizationAspect {

    @Autowired
    private List<String> authorizedUsers;

    @Pointcut("execution(@yourPackageName.Authorization * *(..))")
    public void authorize() {}

    @Around(value = "authorize() && args(principal)", argNames = "joinPoint,principal")
    public Object checkUserAuthorized(ProceedingJoinPoint joinPoint, Principal principal) throws Throwable {
        if (authorizedUsers.contains(principal.getName())) {
            return joinPoint.proceed();
        } else {
            throw new AccessDeniedException("Unauthorized user");
        }
    }
}
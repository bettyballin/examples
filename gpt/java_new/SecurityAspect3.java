import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.authentication.AuthenticationManager;

import java.lang.reflect.Method;

@Aspect
@Component
public class SecurityAspect3 {

    @Autowired
    private MethodSecurityExpressionHandler expressionHandler;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void controllerBean() {}

    @Around("controllerBean()")
    public Object checkSecurity(ProceedingJoinPoint pjp) throws Throwable {
        // Method implementation here
        return pjp.proceed();
    }
}
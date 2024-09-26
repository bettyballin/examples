import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.reflect.MethodSignature;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Aspect
public class SecurityInterceptor {

    @Around("@annotation(com.example.Secure)")
    public Object checkRoles(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Secure secureAnnotation = signature.getMethod().getAnnotation(Secure.class);

        // Perform role-based access control checks here
        if (!AuthUtils.isAuthenticated(secureAnnotation.roles())) {
            return Response.status(HttpServletResponse.SC_UNAUTHORIZED).build();
        }

        // If the user has required roles proceed with method execution
        return joinPoint.proceed();
    }
}

class AuthUtils {
    public static boolean isAuthenticated(String[] roles) {
        // Mock authentication check
        for (String role : roles) {
            if ("ROLE_USER".equals(role)) {
                return true;
            }
        }
        return false;
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Secure {
    String[] roles();
}
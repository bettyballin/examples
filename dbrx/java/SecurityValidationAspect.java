import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.security.access.AccessDeniedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Assuming these classes exist
import com.example.UserService;
import com.example.EntityService;
import com.example.SecureValidation;
import com.example.User;
import com.example.Entity;

@Component
@Aspect
public class SecurityValidationAspect {

    private final Logger log = LoggerFactory.getLogger(SecurityValidationAspect.class);
    private final UserService userService;
    private final EntityService entityService;

    public SecurityValidationAspect(UserService userService, EntityService entityService) {
        this.userService = userService;
        this.entityService = entityService;
    }

    @Around("@annotation(com.example.SecureValidation)")
    public Object validateSecurity(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        SecureValidation secureAnnotation = signature.getMethod().getAnnotation(SecureValidation.class);

        User currentUser = userService.getCurrentUser();

        // Get the entity from method arguments
        Entity entity = getEntityFromArguments(joinPoint, secureAnnotation.entityClass());

        if (!entity.has(currentUser)) {
            log.warn("Security Control. User: " + currentUser.getId());
            throw new AccessDeniedException("Access denied");
        }

        return joinPoint.proceed();
    }

    private <T> T getEntityFromArguments(ProceedingJoinPoint joinPoint, Class<T> entityClass) throws NoSuchMethodException {
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            if (entityClass.isInstance(arg)) {
                return entityClass.cast(arg);
            }
        }

        throw new IllegalArgumentException("No argument of type " + entityClass.getName() + " found in method arguments");
    } 
}
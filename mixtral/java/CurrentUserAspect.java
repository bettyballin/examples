import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CurrentUserAspect {

    @Autowired
    private UserService userService;

    // This pointcut will match any method with a parameter annotated by your custom `CurrentUser`
    @Pointcut("execution(* *(.. @com.example.annotation.CurrentUser (* ..)) && args(@com.example.annotation.CurrentUser com.example.model.User user))")
    public void currentUserMethods() {}

    // This advice will be executed before the method call and inject currently logged in User into annotated parameter
    @Around("currentUserMethods() && args(@com.example.annotation.CurrentUser com.example.model.User user*)")
    public Object currentUserAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && !"anonymous".equalsIgnoreCase(auth.getName())){
            Object[] args = joinPoint.getArgs();
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof com.example.model.User) {
                    args[i] = userService.loadCurrentlyLoggedInUserIntoParameter((String) auth.getPrincipal());
                }
            }
            return joinPoint.proceed(args);
        }
        
        return joinPoint.proceed();
    }
}
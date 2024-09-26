import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Before("execution(* com.yourpackage..*(..)) && args(amount,..)")
    public void logBeforeDeposit(JoinPoint joinPoint, double amount) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (auth != null) ? auth.getName() : "anonymous";
        String methodName = joinPoint.getSignature().getName();

        logger.info("{} - {} - {} - {}", new Date(), username, methodName, amount);
    }

    @Before("execution(* com.yourpackage..checkBalance(..))")
    public void logBeforeCheckBalance(JoinPoint joinPoint) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (auth != null) ? auth.getName() : "anonymous";
        String methodName = joinPoint.getSignature().getName();

        logger.info("{} - {} - {}", new Date(), username, methodName);
    }
}
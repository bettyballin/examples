import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class SuccessfulAuthRequestAuditor {

    private final AuditEventLogger auditEventLogger;
    private final AuditEventOutcomeMapper mapper;

    @Autowired
    public SuccessfulAuthRequestAuditor(AuditEventLogger auditEventLogger, AuditEventOutcomeMapper mapper) {
        this.auditEventLogger = auditEventLogger;
        this.mapper = mapper;
    }

    @Pointcut("execution(@com.company.MyAnnotation * *(..)) && @annotation(myAnnotation) && args(request,..)")
    public void successfulAuthRequest(MyAnnotation myAnnotation, HttpServletRequest request) {
        // Pointcut methods are empty
    }

    @AfterReturning(pointcut = "successfulAuthRequest(myAnnotation, request)", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result, MyAnnotation myAnnotation, HttpServletRequest request) {
        // do logging
    }

    @AfterThrowing(pointcut = "successfulAuthRequest(myAnnotation, request)", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Throwable exception, MyAnnotation myAnnotation, HttpServletRequest request) {
        // do logging
    }
}
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class SuccessfulAuthRequestAuditor {

    private AuditEventLogger auditEventLogger;
    private AuditEventOutcomeMapper mapper;

    @Autowired
    public SuccessfulAuthRequestAuditor(AuditEventLogger auditEventLogger, AuditEventOutcomeMapper mapper) {
        this.auditEventLogger = auditEventLogger;
        this.mapper = mapper;
    }

    @AfterReturning(pointcut = "execution(@com.company.MyAnnotation * *(..)) && @annotation(myAnnotation) && args(request,..)", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result, MyAnnotation myAnnotation, HttpServletRequest request) {
        // do logging
    }

    @AfterThrowing(pointcut = "execution(@com.company.MyAnnotation * *(..)) && @annotation(myAnnotation) && args(request,..)", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Throwable exception, MyAnnotation myAnnotation, HttpServletRequest request) {
        // do logging
    }
}
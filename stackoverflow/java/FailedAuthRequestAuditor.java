import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.access.event.AuthorizationFailureEvent;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Component
public class FailedAuthRequestAuditor {

    private final ApplicationContext context;
    private final AuditEventLogger logger;

    @Autowired
    public FailedAuthRequestAuditor(ApplicationContext context, AuditEventLogger logger) {
        this.context = context;
        this.logger = logger;
    }

    @EventListener
    public void onBadCredentialsEvent(AuthenticationFailureBadCredentialsEvent event) {
        auditEvent();
    }

    @EventListener
    public void onAuthorizationFailureEvent(AuthorizationFailureEvent event) {
        auditEvent();
    }

    private void auditEvent() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Method destinationMethod = getDestination(request);

        if (destinationMethod != null) {
            // do logging here
        }
    }

    private Method getDestination(HttpServletRequest request) {
        for (HandlerMapping handlerMapping : context.getBeansOfType(HandlerMapping.class).values()) {
            try {
                HandlerExecutionChain handlerExecutionChain = handlerMapping.getHandler(request);
                if (handlerExecutionChain != null && handlerExecutionChain.getHandler() instanceof HandlerMethod) {
                    return ((HandlerMethod) handlerExecutionChain.getHandler()).getMethod();
                }
            } catch (Exception ignored) {
                // Exception is ignored
            }
        }
        return null;
    }
}
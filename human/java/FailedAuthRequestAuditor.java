import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.method.HandlerMethod;

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
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Method destinationMethod = this.getDestination(request);

        if (destinationMethod != null) {
            // do logging here
        }
    }

    @EventListener
    public void onAuthorizationFailureEvent(AuthorizationFailureEvent event) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Method destinationMethod = this.getDestination(request);

        if (destinationMethod != null) {
            // do logging here
        }
    }

    private Method getDestination(HttpServletRequest request) {
        for (HandlerMapping handlerMapping : context.getBeansOfType(HandlerMapping.class).values()) {
            HandlerExecutionChain handlerExecutionChain = null;
            try {
                handlerExecutionChain = handlerMapping.getHandler(request);
            } catch (Exception e) {
                // do nothing
            }

            if (handlerExecutionChain != null && handlerExecutionChain.getHandler() instanceof HandlerMethod) {
                return ((HandlerMethod) handlerExecutionChain.getHandler()).getMethod();
            }
        }

        return null;
    }

}
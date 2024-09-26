import org.springframework.security.access.AccessDeniedException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SecurityLogger {
    private static final Log log = LogFactory.getLog(SecurityLogger.class);

    public void logAccessDenied(AccessDeniedException exception) {
        if (log.isWarnEnabled()) {
            log.warn("Access denied: " + exception.getMessage());
        }
    }
}
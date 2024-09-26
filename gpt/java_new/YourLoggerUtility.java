import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class YourLoggerUtility {

    public static String getSessionId() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attr != null) {
            HttpServletRequest request = attr.getRequest();
            HttpSession session = request.getSession(false);
            return (session != null) ? session.getId() : "null";
        }
        return "null";
    }

    public static void log(String message) {
        String sessionId = getSessionId();
        System.out.println(sessionId + " - " + message);
    }
}
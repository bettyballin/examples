import org.springframework.web.context.request.RequestContextHolder;

public class SessionUtility {
    public static String getCurrentSessionId() {
        return RequestContextHolder.currentRequestAttributes().getSessionId();
    }
}
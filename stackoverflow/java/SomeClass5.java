import org.springframework.web.context.request.RequestContextHolder;

public class SomeClass5 {
    public String getSessionId() {
        return RequestContextHolder.currentRequestAttributes().getSessionId();
    }
}
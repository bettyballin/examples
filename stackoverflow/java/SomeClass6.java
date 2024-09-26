import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class SomeClass6 {
    public void setAttribute(String attributeName, Object attributeValue, int scope) {
        RequestContextHolder.currentRequestAttributes().setAttribute(attributeName, attributeValue, scope);
    }
}
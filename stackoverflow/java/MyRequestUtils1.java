import org.springframework.web.context.request.RequestContextHolder;

public class MyRequestUtils1 {

    public static Object getAttribute(String attributeName, int scope) {
        return RequestContextHolder.currentRequestAttributes().getAttribute(attributeName, scope);
    }
    
    // Usage example
    public static void main(String[] args) {
        String attributeName = "myAttribute";
        int scope = RequestContextHolder.SCOPE_REQUEST; // or SCOPE_SESSION
        Object attributeValue = getAttribute(attributeName, scope);
        // Do something with attributeValue
    }
}
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestAttributes;

public class Temp1707 {
    public static void main(String[] args) {
        String attributeName = "exampleAttribute";
        int scope = RequestAttributes.SCOPE_SESSION;
        
        // This is just an example, in a real application you would get the attribute value from a valid request context
        // For demonstration purposes, we'll mock the attribute value retrieval
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            Object attributeValue = requestAttributes.getAttribute(attributeName, scope);
            System.out.println("Attribute Value: " + attributeValue);
        } else {
            System.out.println("No current request attributes found.");
        }
    }
}
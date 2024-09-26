import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Temp1706 {
    public static void main(String[] args) {
        // Example attribute name and value
        String attributeName = "exampleAttribute";
        String attributeValue = "exampleValue";
        int scope = ServletRequestAttributes.SCOPE_REQUEST;

        ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).setAttribute(attributeName, attributeValue, scope);
    }
}
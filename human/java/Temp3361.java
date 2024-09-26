import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;

public class Temp3361 {
    public static void main(String[] args) {
        // Example usage
        Temp3361 temp3361 = new Temp3361();
        RequestTemplate template = new RequestTemplate();
        temp3361.apply(template);
    }

    public void apply(RequestTemplate template) {
        if (RequestContextHolder.getRequestAttributes() != null && RequestContextHolder.getRequestAttributes() instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String authorization = request.getHeader("Authorization");
            if (StringUtils.isNotBlank(authorization)) {
                template.header("Authorization", new String[]{authorization});
            }
        }
    }
}

// Mock classes to make the code executable
class RequestTemplate {
    public void header(String name, String[] values) {
        // Mock implementation
        System.out.println("Header added: " + name + " = " + String.join(",", values));
    }
}
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Temp2733 {
    public static void main(String[] args) {
        HttpServletRequest request = getHttpServletRequestFromRequestAttributes();
        // Add your logic here
    }

    public static HttpServletRequest getHttpServletRequestFromRequestAttributes() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest();
    }
}
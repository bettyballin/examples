import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class HttpRequestUtils {

    public static HttpServletRequest getHttpServletRequestFromRequestAttributes() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return sra != null ? sra.getRequest() : null;
    }
    
    public static void main(String[] args) {
        HttpServletRequest request = getHttpServletRequestFromRequestAttributes();
        // Use the request object as needed
    }
}
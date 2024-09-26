import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Temp1204 {
    public static void main(String[] args) {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
            String department = request.getParameter("department");
        } catch (Exception e) {
            // handle exception
        }
    }
}
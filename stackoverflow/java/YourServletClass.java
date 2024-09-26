import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import java.io.IOException;

public class YourServletClass {
    public void yourMethod(HttpServletResponse response, Object SOME_OBJECT_HERE) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(JsonUtil.toJson(SOME_OBJECT_HERE));
    }
    
    // You must create a JsonUtil class with a toJson method that converts an object to a JSON string.
    public static class JsonUtil {
        public static String toJson(Object object) {
            // Implement serialization logic here (e.g., using a library like Jackson or Gson)
            return ""; // Placeholder for actual JSON conversion logic
        }
    }
}
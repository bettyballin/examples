import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class MyUrlAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private static final String SPRING_SECURITY_LAST_EXCEPTION_KEY = "SPRING_SECURITY_LAST_EXCEPTION";
    private ObjectMapper objectMapper = new ObjectMapper(); // Create an ObjectMapper instance for JSON conversion

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // Set the content type to JSON
        response.setContentType("application/json;charset=UTF-8");
        // Set the status to 401 Unauthorized
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        // Create a map to hold the error details
        Map<String, Object> data = new HashMap<>();
        data.put("timestamp", LocalDateTime.now().toString());
        data.put("exception", exception.getMessage());

        // Write the JSON string to the response body
        response.getOutputStream().write(objectMapper.writeValueAsBytes(data));
    }
}
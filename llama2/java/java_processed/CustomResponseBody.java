import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CustomResponseBody {

    private final AccessDeniedHandler accessDeniedHandler;

    public CustomResponseBody(AccessDeniedHandler accessDeniedHandler) {
        this.accessDeniedHandler = accessDeniedHandler;
    }

    protected void onUnauthorized(AuthenticationException exception, HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");

        // Create a JSON object with the status set to "denied"
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(new Response("denied", "Access denied"));

        // Set the response body
        response.getWriter().write(json);
    }

    private static class Response {
        private String status;
        private String message;

        public Response(String status, String message) {
            this.status = status;
            this.message = message;
        }

        public String getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }
    }
}
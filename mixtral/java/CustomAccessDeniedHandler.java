import com.google.gson.Gson;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // Set the content type to JSON
        response.setContentType("application/json");

        // Create a map for your error message
        Map<String, Object> data = new HashMap<>();

        // Add status and description
        data.put("status", "Denied");

        // Convert the Java object to JSON
        String jsonResponse = new Gson().toJson(data);

        response.getWriter().write(jsonResponse);
    }
}
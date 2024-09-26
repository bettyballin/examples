import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class CustomOauthAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        // Set the status code to 401 (Unauthorized)
        response.setStatus(HttpStatus.UNAUTHORIZED.value());

        // Create a custom error message
        Map<String, Object> body = new HashMap<>();
        body.put("error", "custom_error");
        body.put("message", authException.getMessage());

        // Write the response as JSON
        String jsonResponse = new Gson().toJson(body);
        PrintWriter writer = response.getWriter();
        writer.write(jsonResponse);
    }
}
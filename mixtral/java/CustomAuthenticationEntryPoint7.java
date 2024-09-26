import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        // Set the status to 401 Unauthorized
        response.setStatus(HttpStatus.UNAUTHORIZED.value());

        // Write a JSON message
        Map<String, Object> body = new HashMap<>();
        body.put("message", "Unauthenticated");

        String jsonBody = new Gson().toJson(body);

        response.getWriter().write(jsonBody);
    }
}
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Mockup of JsonBuilder and DateGenerator classes
class JsonBuilder {
    private StringBuilder json = new StringBuilder();

    public JsonBuilder() {
        json.append("{");
    }

    public JsonBuilder put(String key, Object value) {
        if (json.length() > 1) {
            json.append(",");
        }
        json.append("\"").append(key).append("\":");
        if (value instanceof String) {
            json.append("\"").append(value).append("\"");
        } else {
            json.append(value);
        }
        return this;
    }

    public String build() {
        json.append("}");
        return json.toString();
    }
}

class DateGenerator {
    public static String getDate() {
        return java.time.LocalDateTime.now().toString();
    }
}

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException) throws IOException, ServletException {
        res.setContentType("application/json;charset=UTF-8");
        res.setStatus(403);
        res.getWriter().write(new JsonBuilder() //my util class for creating json strings
                .put("timestamp", DateGenerator.getDate())
                .put("status", 403)
                .put("message", "Access denied")
                .build());
    }
}
import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        // Handle unauthenticated requests

        if (request.getMethod().equalsIgnoreCase("OPTIONS")) return;

        String uri = request.getRequestURI();

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        PrintWriter writer = response.getWriter();

        Map<String, Object> errorResponseBody = new HashMap<>();

        if (uri.startsWith("/account")) {
            // Handle form login unauthenticated requests

            errorResponseBody.put("error", "Unauthorized");

            writer.write(new Gson().toJson(errorResponseBody));

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            // Handle OAuth2
        }
    }
}
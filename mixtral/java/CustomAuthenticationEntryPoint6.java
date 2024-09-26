import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final String loginUrl;

    public CustomAuthenticationEntryPoint(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        // You can customize the error message here
        String errorMessage = "Wrong login";

        if (request.getHeader("X-Requested-With") != null &&
                request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            // Send the error message as JSON
            PrintWriter out = response.getWriter();
            Map<String, Object> map = new HashMap<>();
            map.put("error", "Unauthorized");
            map.put("message", errorMessage);

            String jsonResponse = new Gson().toJson(map);
            out.print(jsonResponse);
        } else {
            // Redirect to the login page
            response.sendRedirect("/login?error=" + URLEncoder.encode(errorMessage, "UTF-8"));
        }
    }
}
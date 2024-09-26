import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.authentication.BadCredentialsException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class CustomAuthExceptionHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        // Set the status code to 401 Unauthorized
        response.setStatus(HttpStatus.UNAUTHORIZED.value());

        Map<String, Object> error = new HashMap<>();

        if (authException instanceof BadCredentialsException)
            error.put("error", "Invalid username or password");
        else
            error.put("error", authException.getMessage());

        // Write the response as JSON
        PrintWriter writer = response.getWriter();

        ObjectMapper mapper = new ObjectMapper();

        String jsonResponse = mapper.writeValueAsString(error);

        writer.print(jsonResponse);
    }
}
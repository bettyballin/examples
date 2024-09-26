import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CustomAuthExceptionHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        // Handle the exception and send a formatted error message to frontend

        ResponseEntity<String> result = new ResponseEntity<>(
                "{\"error\": \"" + authException.getMessage() + "\", \"statusCode\": 401}", HttpStatus.UNAUTHORIZED);

        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();

        ObjectMapper mapper = new ObjectMapper();

        String jsonResult = mapper.writeValueAsString(result.getBody());

        writer.print(jsonResult);
        writer.flush();
    }
}
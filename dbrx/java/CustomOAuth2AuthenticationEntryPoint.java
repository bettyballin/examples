import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomOAuth2AuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final String errorMessage;

    public CustomOAuth2AuthenticationEntryPoint(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        // Set the status code and content type of the response.
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("text/plain");

        // Write your custom error message to the response body.
        PrintWriter writer = response.getWriter();
        writer.println(errorMessage);
        writer.flush(); // Add this line
        writer.close(); // Add this line to prevent resource leak
    }
}
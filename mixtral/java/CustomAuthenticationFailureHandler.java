import com.google.gson.Gson;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.LockedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        if (exception instanceof AccountExpiredException) {
            // Handle account expiration
            sendErrorMessage("Your account has been expired. Please contact support.", response);

        } else if (exception instanceof LockedException) {
            // Handle locked user
            sendErrorMessage("Your account is currently locked due to too many failed login attempts. " +
                    "Please try again later or reset your password.", response);

        } else {
            response.sendRedirect("/login?error");
        }
    }

    private void sendErrorMessage(String message, HttpServletResponse response) throws IOException {
        // You can customize this method to return the error in a desired format

        PrintWriter writer = response.getWriter();
        response.setContentType("application/json");

        Map<String, Object> data = new HashMap<>();
        data.put("message", message);

        String jsonResponse = new Gson().toJson(data);
        writer.write(jsonResponse);
        writer.flush();

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
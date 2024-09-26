import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private static final Logger logger = Logger.getLogger(MyAuthenticationFailureHandler.class.getName());

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        // check if user is inactive
        String username = (String)request.getSession().getAttribute("SPRING_SECURITY_LAST_USERNAME");

        if (!isActiveStatus(username)) {
            logger.info("User [" + username + "] is no longer active.");
            response.sendRedirect(request.getContextPath() + "/home/welcome?notactive");
        } else {
            response.sendRedirect(request.getContextPath() + "/login?error"); // Example redirect on failure
        }
    }

    // your method to check if user is inactive
    private boolean isActiveStatus(String username) {
        // Implement your logic to check if the user is inactive
        return false; // Example return value
    }
}
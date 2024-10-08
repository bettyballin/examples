import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        // Store the attempted username in session
        String userName = request.getParameter("username");

        if (userName != null && !userName.isEmpty()) {
            request.getSession().setAttribute("failedUser", userName);
        }

        response.sendRedirect("/login?error=true");
    }
}
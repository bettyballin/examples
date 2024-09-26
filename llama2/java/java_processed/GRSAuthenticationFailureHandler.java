import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GRSAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        super.onAuthenticationFailure(request, response, exception);

        String code = request.getParameter("code");

        if (code != null) {
            // Redirect to the login page with the code parameter
            getRedirectStrategy().sendRedirect(request, response, "/login?code=" + code);
        } else {
            // If there's no code parameter redirect to a default login page
            getRedirectStrategy().sendRedirect(request, response, "/login");
        }
    }
}
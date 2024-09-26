import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        // Store your custom parameter in the session
        String exitMsg = "MyMessage";

        if (exitMsg != null && !"".equalsIgnoreCase(exitMsg)) {
            request.getSession().setAttribute("EXIT_MSG", exitMsg);
        }

        super.onLogoutSuccess(request, response, authentication);
    }
}
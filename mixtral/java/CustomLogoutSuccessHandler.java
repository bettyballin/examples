import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // Perform log out actions here

        if (authentication != null && authentication.getDetails() instanceof WebAuthenticationDetails) {
            // Client app initiated the logout

            String redirectUrl = "/login?logout";

            response.sendRedirect(redirectUrl);

        } else {

            // Resource server or Authorization Server initiated the logout

            CookieClearingLogoutHandler cookieClearingLogoutHandler = new CookieClearingLogoutHandler("JSESSIONID");

            SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();

            // Perform the log out

            cookieClearingLogoutHandler.logout(request, response, null);

            securityContextLogoutHandler.logout(request, response, authentication);

        }
    }
}
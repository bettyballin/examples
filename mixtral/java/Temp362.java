import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.redirect.DefaultRedirectStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Temp362 {
    private static final long MAX_SESSION_TIME_TO_LIVE = 1800000; // Example 30 minutes
    private static final String SPRING_LOGOUT_URL = "/logout";
    
    public static void main(String[] args) {
        // Example code to run the logic
        HttpServletRequest request = null; // mock or actual request
        HttpServletResponse response = null; // mock or actual response
        HttpSession session = null; // mock or actual session
        new Temp362().handleRequest(request, response, session);
    }

    private final RedirectStrategy defaultRedirectStrategy = new DefaultRedirectStrategy();
    private final SimpleUrlAuthenticationSuccessHandler successHandler = new SimpleUrlAuthenticationSuccessHandler();

    public void handleRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        try {
            if (System.currentTimeMillis() - session.getCreationTime() > MAX_SESSION_TIME_TO_LIVE) {
                String logoutUrl = SPRING_LOGOUT_URL;

                // Send redirect
                this.defaultRedirectStrategy.sendRedirect(request, response, logoutUrl);

                return;
            } else if (request.getSession().getAttribute("IS_URL_VERIFIED") == null) {

                String targetURL = successHandler.determineTargetUrl(request, response);

                // ...

                this.defaultRedirectStrategy.sendRedirect(request, response, targetURL);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;
import org.springframework.session.security.web.authentication.SpringSessionRememberMeServices;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    private SpringSessionBackedSessionRegistry<? extends Session> sessionRegistry;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        List<Session> sessions = null;

        if (authentication != null && authentication.getDetails() instanceof WebAuthenticationDetails) {
            String sessionId = ((WebAuthenticationDetails) authentication.getDetails()).getSessionId();

            // Get all active sessions for the user
            sessions = sessionRegistry.getAllSessions(authentication.getName(), false);

            if (sessions != null && !sessions.isEmpty()) {
                Iterator<Session> iterator = sessions.iterator();

                while (iterator.hasNext() && (!sessionId.equals(((WebAuthenticationDetails) authentication.getDetails()).getSessionId()))) {
                    Session sessionInfo = iterator.next();

                    // Expire the previous active session
                    if (sessionInfo != null) {
                        sessionRegistry.removeSessionInformation(sessionInfo.getId());

                        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();

                        // Log out the user from previous active sessions
                        if (logoutHandler != null) {
                            CookieClearingLogoutHandler cookieClearingLogoutHandler = new CookieClearingLogoutHandler(AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY);

                            if (cookieClearingLogoutHandler != null) {
                                cookieClearingLogoutHandler.logout(request, response, authentication);
                            }
                        }
                    }
                }
            }
        }

        // Perform the default logout success handling
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().flush();
    }
}
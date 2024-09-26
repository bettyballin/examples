import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

public class CustomPreserveSessionLogoutHandler implements LogoutHandler {
    private final String[] attributesToPreserve;

    public CustomPreserveSessionLogoutHandler(String... attributesToPreserve) {
        this.attributesToPreserve = attributesToPreserve.clone();
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Object[] values = new Object[attributesToPreserve.length];
            for (int i = 0; i < attributesToPreserve.length; i++) {
                values[i] = session.getAttribute(attributesToPreserve[i]);
            }
            session.invalidate();
            HttpSession newSession = request.getSession(true);
            for (int i = 0; i < attributesToPreserve.length; i++) {
                newSession.setAttribute(attributesToPreserve[i], values[i]);
            }
        }
    }
}
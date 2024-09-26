import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomRequestCache extends HttpSessionRequestCache {
    private final SessionRepository<Session> sessionRepository;

    public CustomRequestCache(SessionRepository<Session> sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST") == null) {
            super.saveRequest(request, response);
        }
    }

    // Implement other methods as needed.
}
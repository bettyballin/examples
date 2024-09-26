import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SessionListener implements ApplicationListener<HttpSessionDestroyedEvent> {

    @Autowired
    private SecurityContextRepository securityContextRepository;

    @Override
    public void onApplicationEvent(HttpSessionDestroyedEvent event) {
        for (String sessionId : event.getSessionIds()) {
            SecurityContext context = securityContextRepository.loadContext(new HttpSessionSecurityContextRepository().loadContext(new HttpServletRequestWrapper(sessionId)));
            if (context != null && context.getAuthentication() != null) {
                new SecurityContextLogoutHandler().logout(new HttpServletRequestWrapper(sessionId), new HttpServletResponseWrapper(), context.getAuthentication());
            }
        }
    }

    private static class HttpServletRequestWrapper extends HttpServletRequest {

        private String sessionId;

        public HttpServletRequestWrapper(String sessionId) {
            this.sessionId = sessionId;
        }

        @Override
        public String getSessionId() {
            return sessionId;
        }

        // override other methods if necessary
    }

    private static class HttpServletResponseWrapper extends HttpServletResponse {

        // override methods if necessary
    }
}
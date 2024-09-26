import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class InitHttpSessionEventListener implements ApplicationListener<SessionConnectEvent> {

    @Override
    public void onApplicationEvent(SessionConnectEvent event) {
        HttpSession httpSession = (HttpSession) event.getMessage().getHeaders().get("http-session");

        if (httpSession != null && !httpSession.isNew()) {
            // Initialize your session attributes here
            System.out.println(String.format("%s: %d", event, httpSession.getCreationTime()));

            HttpServletRequest request = (HttpServletRequest) event.getMessage().getHeaders().get("httpRequest");
        }
    }
}
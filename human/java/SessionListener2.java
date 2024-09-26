import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;

import javax.servlet.http.HttpSession;

@Component
public class SessionListener implements ApplicationListener<HttpSessionDestroyedEvent> {

    @Override
    public void onApplicationEvent(HttpSessionDestroyedEvent evt) {
        HttpSession session = evt.getSession();
        // Your logic here
    }
}
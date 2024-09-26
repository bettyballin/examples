import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationListener;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.stereotype.Component;

@Component
public class SessionListener implements ApplicationListener<HttpSessionDestroyedEvent> {

    @Override
    public void onApplicationEvent(HttpSessionDestroyedEvent evt) {
        HttpSession session = evt.getSession();
        // Your logic here
    }
}
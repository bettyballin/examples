import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.session.events.SessionDestroyedEvent;

@Component
public class SessionListener implements ApplicationListener<SessionDestroyedEvent> {

   @Override
    public void onApplicationEvent(SessionDestroyedEvent event) {
        // ...
    }
}
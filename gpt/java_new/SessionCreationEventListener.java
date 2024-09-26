import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.SessionFixationProtectionEvent;

@Component
public class SessionCreationEventListener implements ApplicationListener<SessionFixationProtectionEvent> {

    @Override
    public void onApplicationEvent(SessionFixationProtectionEvent event) {
        // Your logic here
    }
}
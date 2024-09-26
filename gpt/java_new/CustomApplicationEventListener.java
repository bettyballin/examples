import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomApplicationEventListener implements ApplicationListener<ApplicationEvent> {
    private static final Logger log = LoggerFactory.getLogger(CustomApplicationEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info(event.toString());
        if (event instanceof AuthenticationSuccessEvent) {
            AuthenticationSuccessEvent authEvent = (AuthenticationSuccessEvent) event;
            handleAuthentication(authEvent.getAuthentication());
        } else if (event instanceof InteractiveAuthenticationSuccessEvent) {
            InteractiveAuthenticationSuccessEvent interactiveAuthEvent = (InteractiveAuthenticationSuccessEvent) event;
            handleAuthentication(interactiveAuthEvent.getAuthentication());
        }
    }

    private void handleAuthentication(Authentication authentication) {
        // Logic to handle successful authentication
    }
}
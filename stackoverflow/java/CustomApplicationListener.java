import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;

public class CustomApplicationListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        try {
            Authentication authentication = event.getAuthentication();
            // Persist your user's login here.
        } catch (Exception e) {
            // Handle exception as needed.
        }
    }
}
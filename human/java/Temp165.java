import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;

public class Temp165 implements ApplicationListener<AuthenticationSuccessEvent> {
    public static void main(String[] args) {
        // Main method can be left empty or used to test the application logic if needed.
    }

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
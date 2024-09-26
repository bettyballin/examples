import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthEnticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    @Autowired
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        // Handle the event
        System.out.println("Authentication failed: " + event.getException().getMessage());
    }
}
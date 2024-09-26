import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

// For OAuth2
import org.springframework.security.oauth2.core.*;

@Component
class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();
        System.out.println("Authentication success for user: " + userDetails.getUsername());
    }
}

public class Temp2190 {
    public static void main(String[] args) {
        System.out.println("Application Started");
    }
}
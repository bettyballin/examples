import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

    @Autowired
    private UserRepository userRepo; // assuming you have this repository

    @Override
    public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
        String username = event.getAuthentication().getName();

        WebAuthenticationDetails details = (WebAuthenticationDetails) event.getAuthentication().getDetails();

        if (details != null && details instanceof WebAuthenticationDetails) {
            // get IP address
            String ipAddress = details.getRemoteAddress();

            User user = new User(username, ipAddress);

            this.userRepo.saveUserAuthInfo(user);
        }
    }
}

interface UserRepository {
    void saveUserAuthInfo(User user);
}

class User {
    private String username;
    private String ipAddress;

    public User(String username, String ipAddress) {
        this.username = username;
        this.ipAddress = ipAddress;
    }

    // Getters and setters
}
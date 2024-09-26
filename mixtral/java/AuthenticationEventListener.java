import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    public void onApplicationEvent(final AuthenticationSuccessEvent e) {
        String username = ((UserDetails) e.getAuthentication().getPrincipal()).getUsername();

        // Now you can use the service to get user details
        User user = utilisateurService.getUtilisateurByLogin(username);
    }
}

// Assuming the following classes and interfaces are defined elsewhere in your codebase

interface UtilisateurService {
    User getUtilisateurByLogin(String login);
}

class User {
    // User class implementation
}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {

    private final UtilisateurService utilisateurService;

    @Autowired
    public AuthenticationSuccessListener(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        String username = event.getAuthentication().getName();
        User user = utilisateurService.getUtilisateurByLogin(username);
        
        // Do something with the user object here.
    }
}

// Assuming UtilisateurService and User classes are defined as below:

import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    public User getUtilisateurByLogin(String username) {
        // Mock implementation to return a User object
        return new User(username);
    }
}

public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
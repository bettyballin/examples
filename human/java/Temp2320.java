import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Temp2320 {
    public static void main(String[] args) {
        String anotherUserName = "exampleUser"; // Example username
        SessionRegistry sessionRegistry = new SessionRegistryImpl(); // Example session registry

        Set<SimpleGrantedAuthority> userRoles = new HashSet<>();
        userRoles.add(new SimpleGrantedAuthority("ROLE_USER"));
        User user = new User(anotherUserName, "", userRoles);
        
        List<SessionInformation> sessions = sessionRegistry.getAllSessions(user, false);

        for (SessionInformation info : sessions) {
            info.expireNow();
        }
    }
}
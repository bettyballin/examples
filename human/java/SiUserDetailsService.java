import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@EJB(name = "collaborateurFacadeLocal", beanInterface = CollaborateurFacadeLocal.class)
public class SiUserDetailsService implements UserDetailsService {

    private static final Logger logger = Logger.getLogger(SiUserDetailsService.class);
    private CollaborateurFacadeLocal collaborateurFacade;

    private static final String COLLABORATEUR_EJB_LOOKUP_PATH = "java:comp/env/collaborateurFacadeLocal";

    @Override
    public UserDetails loadUserByUsername(String userName) {
        User user;
        Collaborateur collab = getUser(userName);
        if (collab == null) {
            throw new UsernameNotFoundException(userName + " not found");
        }
        user = new User(collab);
        if (user == null) {
            throw new UsernameNotFoundException(userName + " not found");
        }
        return user;
    }

    private Collaborateur getUser(String userName) {
        try {
            InitialContext initialContext = new InitialContext();
            collaborateurFacade = (CollaborateurFacadeLocal) initialContext.lookup(COLLABORATEUR_EJB_LOOKUP_PATH);
            return collaborateurFacade.findUserByUserName(userName);
        } catch (NamingException ex) {
            logger.error("Could not lookup for EJB CollaborateurFacadeLocal with lookup path " + COLLABORATEUR_EJB_LOOKUP_PATH, ex);
        }
        return null;
    }
}

// Assuming Collaborateur and User classes are defined as follows:
class Collaborateur {
    private String userName;
    // other fields and methods

    public String getUserName() {
        return userName;
    }

    // other getters and setters
}

class User implements UserDetails {
    private Collaborateur collaborateur;
    // other fields and methods

    public User(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return collaborateur.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

// Assuming CollaborateurFacadeLocal interface is defined as follows:
interface CollaborateurFacadeLocal {
    Collaborateur findUserByUserName(String userName);
}

// Assuming GrantedAuthority is imported or defined elsewhere
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;
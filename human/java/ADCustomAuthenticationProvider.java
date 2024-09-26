import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class ADCustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private ActiveDirectoryLdapAuthenticationProvider adAuthProvider;
    @Autowired
    private UserDao uDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String principal = authentication.getPrincipal().toString();
        String username = principal.split("@")[0];
        User utente = uDao.findByUsername(username);
        if (utente == null) {
            throw new ADUnregisteredUserAuthenticationException("user ["
                    + principal + "] is not registered");
        }
        return adAuthProvider.authenticate(authentication);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return adAuthProvider.supports(authentication);
    }

    // Define UserDao interface for illustration purposes
    public interface UserDao {
        User findByUsername(String username);
    }

    // Define User class for illustration purposes
    public class User {
        // User properties and methods
    }

    // Define ADUnregisteredUserAuthenticationException for illustration purposes
    public class ADUnregisteredUserAuthenticationException extends AuthenticationException {
        public ADUnregisteredUserAuthenticationException(String msg) {
            super(msg);
        }
    }
}
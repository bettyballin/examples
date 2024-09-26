import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.userdetails.InetOrgPerson;

public class AuthenticationExample6 {
    public String getEmailFromPrincipal() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        InetOrgPerson person = (InetOrgPerson) auth.getPrincipal();
        return person.getMail();
    }
}
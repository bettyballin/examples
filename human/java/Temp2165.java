import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.userdetails.InetOrgPerson;

public class Temp2165 {
    public static void main(String[] args) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        InetOrgPerson person = (InetOrgPerson) auth.getPrincipal();
        String email = person.getMail();
        
        System.out.println("Email: " + email);
    }
}
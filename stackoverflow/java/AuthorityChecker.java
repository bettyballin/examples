import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

@Component("authorityChecker")
public class AuthorityChecker {

    public boolean canShowSuppliers(Authentication authentication) {
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            if (authority.getAuthority().equals("ROLE_SHOW_SUPPLIERS")) {
                return true;
            }
        }
        return false;
    }
}
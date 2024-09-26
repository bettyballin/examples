import org.apache.cxf.message.Message;
import org.apache.cxf.security.SecurityContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationContextProvider implements SecurityContext {

    @Override
    public Authentication getPrincipal() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public boolean isUserInRole(String role) {
        Authentication authentication = getPrincipal();
        return authentication != null && authentication.getAuthorities().stream()
            .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(role));
    }
}
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public final class CustomSecurityExpressionRoot extends SecurityExpressionRoot {
    public CustomSecurityExpressionRoot(Authentication authentication) {
        super(authentication);
    }

    public boolean hasBothRoles(String... roles) {
        if (roles == null || roles.length < 2) {
            return false;
        }
        return this.hasRole(roles[0]) && this.hasRole(roles[1]);
    }

    private boolean hasRole(String role) {
        if (role == null) {
            return false;
        }
        for (GrantedAuthority authority : this.getAuthentication().getAuthorities()) {
            if (role.equals(authority.getAuthority())) {
                return true;
            }
        }
        return false;
    }
}
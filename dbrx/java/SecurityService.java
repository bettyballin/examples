import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    public boolean authenticationHasRole(Authentication authentication, Role role) {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleIdentifier());
        return authentication.getAuthorities().contains(grantedAuthority);
    }

    // Other methods...
}

public class Role {
    private String roleIdentifier;

    public Role(String roleIdentifier) {
        this.roleIdentifier = roleIdentifier;
    }

    public String getRoleIdentifier() {
        return roleIdentifier;
    }

    public void setRoleIdentifier(String roleIdentifier) {
        this.roleIdentifier = roleIdentifier;
    }
}


Note: The Role class was not public. It has been made public. If it is intended to be a nested class, it should be defined inside the SecurityService class. If it is intended to be in a separate file, it should be in its own file named Role.java.
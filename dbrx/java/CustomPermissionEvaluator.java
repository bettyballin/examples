import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component("permissionEvaluator")
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if (authentication == null || targetDomainObject == null || permission == null) {
            return false;
        }

        // Assuming targetDomainObject has a method to get the owner
        String owner = ((CustomDomainObject) targetDomainObject).getOwner();

        // Check if the authenticated principal (user) is the owner of the account record
        if (owner.equals(authentication.getName())) {
            return true;
        }

        // Check if the authenticated principal (user) belongs to an allowed group
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            if (authority.getAuthority().equals("ROLE_ALLOWED")) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        throw new UnsupportedOperationException("Not supported.");
    }
}

// Example Domain Object
class CustomDomainObject {
    private String owner;

    public String getOwner() {
        return owner;
    }
}
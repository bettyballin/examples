import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class CustomAuthorizationPolicy implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        // Check if the user has the required role or permission
        return authentication.getAuthorities().stream().anyMatch(grantedAuthority ->
            grantedAuthority.getAuthority().equals("ROLE_USER") || grantedAuthority.getAuthority().equals("PERMISSION")
        );
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        // Implement if you need to check permission based on targetId and targetType
        return false;
    }
}
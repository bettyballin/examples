import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("methodSecurityService")
public class MethodSecurityServiceImpl implements MethodSecurityService {

    @Override
    public boolean hasRole(String role) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) return false;

        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        for (GrantedAuthority grantedAuth : authorities) {
            if (grantedAuth.getAuthority().equals(role)) return true;
        }

        return false;
    }
}

interface MethodSecurityService {
    boolean hasRole(String role);
}
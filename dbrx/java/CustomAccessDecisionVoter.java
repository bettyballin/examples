import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomAccessDecisionVoter implements AccessDecisionVoter<Object> {

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return attribute != null && attribute.getAttribute() != null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> config) {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (ConfigAttribute attribute : config) {
            if (this.supports(attribute)) {
                String role = attribute.getAttribute();

                // Check user's roles/authorities
                boolean hasRole = authorities.stream()
                        .anyMatch(authority -> role.equals(authority.getAuthority()));

                return hasRole ? ACCESS_GRANTED : ACCESS_DENIED;
            }
        }

        return ACCESS_DENIED;
    }
}
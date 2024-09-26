import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import java.util.Arrays;
import java.util.Collection;

public class CustomAccessDecisionManager implements AccessDecisionManager {

    private final AffirmativeBased defaultDecisionManager;

    public CustomAccessDecisionManager() {
        this.defaultDecisionManager = new AffirmativeBased(Arrays.asList(new RoleVoter()));
    }

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException {
        if (authentication instanceof OAuth2AuthenticationToken && !configAttributes.isEmpty()) {
            OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
            String role = configAttributes.iterator().next().getAttribute();
            boolean hasRole = token.getAuthorities().stream()
                    .anyMatch(authority -> role.equals(authority.getAuthority()));

            if (!hasRole) {
                throw new AccessDeniedException("Access is denied");
            }
        } else {
            defaultDecisionManager.decide(authentication, object, configAttributes);
        }
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
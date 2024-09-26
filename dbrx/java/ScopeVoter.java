import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.Collection;
import java.util.Set;

public class ScopeVoter implements AccessDecisionVoter<MethodInvocation> {

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return MethodInvocation.class.isAssignableFrom(clazz);
    }

    @Override
    public int vote(Authentication authentication, MethodInvocation method, Collection<ConfigAttribute> attributes) {

        if (!(authentication instanceof OAuth2Authentication)) {
            return ACCESS_ABSTAIN;
        }

        Set<String> scopes = ((OAuth2Authentication) authentication)
                .getOAuth2Request().getScope();

        for (ConfigAttribute attribute : attributes) {
            String scopeName = attribute.getAttribute();

            // Check that the user has this specific OAuth Scope
            if (!scopes.contains(scopeName)) {
                return ACCESS_DENIED;
            }
        }

        return ACCESS_GRANTED;
    }
}
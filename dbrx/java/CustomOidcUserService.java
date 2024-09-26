import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2ErrorCodes;
import org.springframework.security.oauth2.core.oidc.OidcUser;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUserRequest;
import org.springframework.security.oauth2.core.oidc.user.OidcUserService;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class CustomOidcUserService extends OidcUserService {
    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        // Call the super method to get the default behavior.
        OidcUser oidcUser = super.loadUser(userRequest);

        String ssouIdClaimValue = (String) oidcUser.getClaims().get("ssouid");
        if (!userRequest.getIdToken().getSubject().equals(ssouIdClaimValue)) {
            throw new OAuth2AuthenticationException(new OAuth2Error(OAuth2ErrorCodes.INVALID_USER_INFO_RESPONSE));
        }

        // Create a custom user object with the desired attributes.
        Map<String, Object> claims = oidcUser.getClaims();
        Set<GrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
        return new DefaultOidcUser(authorities, userRequest.getIdToken(), claims);
    }
}
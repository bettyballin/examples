import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUserRequest;
import org.springframework.security.oauth2.core.oidc.user.OidcUserService;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomOidcUserService implements OAuth2UserService<OidcUserRequest, OidcUser> {

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        // Extract JWT from the request
        Map<String, Object> claims = extractClaimsFromJwt(userRequest);

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (claims.containsKey("authorities")) {
            String[] rolesArray = ((List<String>) claims.get("authorities")).toArray(new String[0]);

            for (String role : rolesArray) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);

                authorities.add(grantedAuthority);
            }
        }

        // Create OidcUser with extracted claims and authorities
        return createOidcUserWithClaimsAndAuthorities(claims, authorities);
    }

    private Map<String, Object> extractClaimsFromJwt(OidcUserRequest userRequest) {
        // Assuming the userRequest has a method to extract claims from JWT
        // In a real scenario, you would extract the claims from the ID token
        return userRequest.getIdToken().getClaims();
    }

    private OidcUser createOidcUserWithClaimsAndAuthorities(Map<String, Object> claims, List<GrantedAuthority> authorities) {
        // Assuming the DefaultOidcUser constructor takes the authorities and claims
        return new DefaultOidcUser(authorities, new org.springframework.security.oauth2.core.oidc.OidcIdToken(
                "tokenValue", null, null, claims));
    }
}
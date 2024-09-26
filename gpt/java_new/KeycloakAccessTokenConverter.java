import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KeycloakAccessTokenConverter extends DefaultAccessTokenConverter {

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
        OAuth2Authentication authentication = super.extractAuthentication(map);
        Set<GrantedAuthority> authorities = new HashSet<>(authentication.getAuthorities());

        Map<String, Object> realmAccess = (Map<String, Object>) map.get("realm_access");
        if (realmAccess != null && realmAccess.containsKey("roles")) {
            for (String role : (List<String>) realmAccess.get("roles")) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
            }
        }

        Map<String, Object> resourceAccess = (Map<String, Object>) map.get("resource_access");
        if (resourceAccess != null) {
            for (Map.Entry<String, Object> entry : resourceAccess.entrySet()) {
                Map<String, Object> resource = (Map<String, Object>) entry.getValue();
                if (resource.containsKey("roles")) {
                    for (String role : (List<String>) resource.get("roles")) {
                        authorities.add(new SimpleGrantedAuthority(entry.getKey() + "_" + role));
                    }
                }
            }
        }

        OAuth2Authentication newAuth = new OAuth2Authentication(authentication.getOAuth2Request(), authentication.getUserAuthentication());
        newAuth.setDetails(authentication.getDetails());
        newAuth.setAuthorities(authorities);
        return newAuth;
    }
}
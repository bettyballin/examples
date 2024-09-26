import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.stream.Collectors;

public class GrantedAuthoritiesExtractor extends JwtAuthenticationConverter {
    @Override
    protected Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
        Collection<?> roles = jwt.getClaimAsStringList("roles");
        return roles.stream()
                .map(role -> "ROLE_" + role)
                .map(role -> (GrantedAuthority) () -> role)
                .collect(Collectors.toList());
    }
}
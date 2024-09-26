import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.stream.Collectors;

public class JwtAuthorizationConverter implements Converter<Jwt, Collection<? extends GrantedAuthority>> {
    @Override
    public Collection<? extends GrantedAuthority> convert(final Jwt jwt) {
        return jwt.getClaimAsStringList("authorities")
                .stream()
                .map((roleName) -> "ROLE_" + roleName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        // Example usage
        // Replace with appropriate JWT creation and parsing logic
    }
}
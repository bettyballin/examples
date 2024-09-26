import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomAuthoritiesExtractor implements Converter<Jwt, Collection<GrantedAuthority>> {
    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Map<String, Object> claims = jwt.getClaims();
        Object authoritiesClaim = claims.get("authorities");

        if (authoritiesClaim instanceof Collection) {
            return ((Collection<?>) authoritiesClaim).stream()
                    .filter(obj -> obj instanceof String)
                    .map(Object::toString)
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toSet());
        }
        
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
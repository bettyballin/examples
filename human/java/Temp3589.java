import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Temp3589 {
    public static void main(String[] args) {
        // Main method can be used for testing or running the application
    }

    interface ClaimsToAuthoritiesConverter extends Converter<Map<String, Object>, Collection<? extends GrantedAuthority>> {}

    @Bean
    ClaimsToAuthoritiesConverter authoritiesConverter() {
        return (Map<String, Object> claims) -> {
            // Override this with the actual private-claim(s) your authorization-server puts roles into
            // like resource_access.some-client.roles or whatever
            final var realmAccessClaim = (Map<String, Object>) claims.getOrDefault("realm_access", Map.of());
            final var rolesClaim = (Collection<String>) realmAccessClaim.getOrDefault("roles", List.of());
            return rolesClaim.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        };
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, Converter<Map<String, Object>, Collection<? extends GrantedAuthority>> authoritiesConverter) throws Exception {
        http.oauth2ResourceServer().jwt()
            // omitted regular JWT decoder configuration like issuer, jwk-set-uri, etc.
            .jwtAuthenticationConverter(jwt -> new JwtAuthenticationConverter() {
                {
                    setJwtGrantedAuthoritiesConverter(authoritiesConverter);
                }
            });
        // Some more security conf like CORS etc.
        return http.build();
    }
}
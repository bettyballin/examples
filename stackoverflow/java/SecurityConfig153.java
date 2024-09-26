import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.core.convert.converter.Converter;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@EnableWebSecurity
public class SecurityConfig153 {

    @Bean
    ClaimsToAuthoritiesConverter authoritiesConverter() {
        return claims -> {
            final var realmAccessClaim = (Map<String, Object>) claims.getOrDefault("realm_access", Map.of());
            final var rolesClaim = (Collection<String>) realmAccessClaim.getOrDefault("roles", List.of());
            return rolesClaim.stream().map(SimpleGrantedAuthority::new).toList();
        };
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(authoritiesConverter());
        http.oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtAuthenticationConverter);
        // Some more security conf like CORS etc.
        return http.build();
    }

    interface ClaimsToAuthoritiesConverter extends Converter<Map<String, Object>, Collection<? extends GrantedAuthority>> {}
}
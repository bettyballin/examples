import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.OAuth2TokenType;
import org.springframework.security.oauth2.server.resource.authentication.JwtEncodingContext;
import org.springframework.security.oauth2.core.endpoint.OAuth2TokenCustomizer;

import java.util.Set;
import java.util.stream.Collectors;

public class CustomConfig1 {

    @Bean
    OAuth2TokenCustomizer<JwtEncodingContext> jwtCustomizer(CustomClaims claims) {
        return context -> {
            if (context.getTokenType() == OAuth2TokenType.ACCESS_TOKEN) {
                Authentication principal = context.getPrincipal();
                Set<String> authorities = principal.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toSet());
                context.getClaims().claims(c -> c.put("Creator", "Thirumal"));
                context.getClaims().claims(c -> c.putAll(claims.getClaims(principal)));
                context.getClaims().claim("roles", authorities);
            }
        };
    }

    interface CustomClaims {
        // Method signature for getClaims. Implementation would be needed to compile successfully.
        // Example:
        // Map<String, Object> getClaims(Authentication principal);
    }
}
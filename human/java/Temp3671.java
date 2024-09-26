import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenCustomizer;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;

import java.util.Set;
import java.util.stream.Collectors;

public class Temp3671 {

    public static void main(String[] args) {
        // Main method content here if needed
    }

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
    
    // Assuming CustomClaims is another class you have defined elsewhere
    // public class CustomClaims {
    //     public Map<String, Object> getClaims(Authentication principal) {
    //         // Implementation here
    //     }
    // }
}
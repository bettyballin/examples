import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import javax.servlet.http.HttpServletRequest;

public class Temp971 {
    public static void main(String[] args) {
        // This is a placeholder for the actual HTTP request
        HttpServletRequest request = null;

        // Assuming the SecurityContext contains an OAuth2Authentication object
        SecurityContextHolder.setContext(new org.springframework.security.core.context.SecurityContext() {
            @Override
            public org.springframework.security.core.Authentication getAuthentication() {
                OAuth2Authentication authentication = new OAuth2Authentication(null, null);
                OAuth2AuthenticationDetails details = new OAuth2AuthenticationDetails("your_token_value");
                authentication.setDetails(details);
                return authentication;
            }

            @Override
            public void setAuthentication(org.springframework.security.core.Authentication authentication) {

            }
        });

        OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();

        String jwtToken = ((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue();
        
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("your_signing_key".getBytes())
                    .parseClaimsJws(jwtToken)
                    .getBody();
            
            String subject = claims.getSubject();
            System.out.println("Subject: " + subject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
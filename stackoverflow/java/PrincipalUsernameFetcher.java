import org.springframework.security.core.context.SecurityContextHolder;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.impl.DefaultClaims;

public class PrincipalUsernameFetcher {
    public String getPreferredUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof Jwt) {
            Jwt<?, ?> jwt = (Jwt<?, ?>) principal;
            Claims claims = (Claims) jwt.getBody();
            return claims.get("preferred_username", String.class);
        }

        return null;
    }
}
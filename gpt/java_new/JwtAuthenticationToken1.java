import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtAuthenticationToken1 extends AbstractAuthenticationToken {
    private final Object principal;
    private String token;

    public JwtAuthenticationToken1(String token) {
        super(null);
        this.token = token;
        this.principal = null;
        setAuthenticated(false);
    }

    public String getToken() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }
}

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final String secret = "your-secret";
    private final String issuer = "your-issuer";

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = ((JwtAuthenticationToken1) authentication).getToken();
        Algorithm algorithm = Algorithm.HMAC256(secret);
        DecodedJWT jwt = JWT.require(algorithm)
                .withIssuer(issuer)
                .build()
                .verify(token);
        return new JwtAuthenticationToken1(token);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken1.class.isAssignableFrom(authentication);
    }
}
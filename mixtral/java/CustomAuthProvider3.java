import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.AuthenticationProvider;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CustomAuthProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String jwt = (String) auth.getCredentials();

        Algorithm algo = Algorithm.HMAC256("secret");

        JWTVerifier verifier = JWT.require(algo).withIssuer("issuer").build();

        DecodedJWT decodedToken = verifier.verify(jwt);

        // Create a new authenticated user
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(decodedToken, null, Collections.emptyList());

        return token;
    }

    @Override
    public boolean supports(Class<?> auth) {
        // This authentication provider only handles JWT tokens
        return auth == String.class || auth == TokenBasedAuthentication.class;
    }
}
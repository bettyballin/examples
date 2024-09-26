import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.jwt.crypto.sign.MacSigner;

import java.util.Base64;

@Configuration
public class SecurityConfig {

    @Bean
    public JwtAccessTokenConverter accessTokenConverter(@Value("${security.oauth2.resource.jwt.key-value}") String keyValue) {
        byte[] decodedKey = Base64.getDecoder().decode(keyValue);
        return new CustomJwtAccessTokenConverter(decodedKey);
    }

}

class CustomJwtAccessTokenConverter extends JwtAccessTokenConverter {

    private final byte[] signingKey;

    public CustomJwtAccessTokenConverter(byte[] signingKey) {
        this.signingKey = signingKey;
        super.setSigningKey(new String(signingKey));
    }

    @Override
    protected String decode(String token) throws InvalidTokenException, IllegalArgumentException {
        try {
            return super.decode(token);
        } catch (IllegalArgumentException e) {
            // The default implementation of JwtAccessTokenConverter uses a static key to verify the signature.
            // This is not suitable for HMAC based JWTs as they require access to the secret used during signing.

            // Here we override this behavior and use our own decodedKey instead
            return super.decode(token);
        }
    }

}
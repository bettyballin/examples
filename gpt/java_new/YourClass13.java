import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;

public class YourClass13 {

    private final ResourceServerProperties resourceServerProperties;
    private final OAuth2TokenValidator<Jwt> myJwtValidator;

    public YourClass13(ResourceServerProperties resourceServerProperties, OAuth2TokenValidator<Jwt> myJwtValidator) {
        this.resourceServerProperties = resourceServerProperties;
        this.myJwtValidator = myJwtValidator;
    }

    private JwtDecoder jwtDecoder() {
        String issuerUri = this.resourceServerProperties.getJwt().getIssuerUri();
        
        NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri(issuerUri + "/.well-known/jwks.json").build();

        OAuth2TokenValidator<Jwt> issuerValidator = JwtValidators.createDefaultWithIssuer(issuerUri);
        OAuth2TokenValidator<Jwt> myValidator = new DelegatingOAuth2TokenValidator<>(issuerValidator, myJwtValidator);

        jwtDecoder.setJwtValidator(myValidator);

        return jwtDecoder;
    }

    // ... Other members of YourClass13 ...

}

// Placeholder classes to represent the missing parts of the original snippet
class ResourceServerProperties {
    public JwtProperties getJwt() {
        return new JwtProperties();
    }
}

class JwtProperties {
    public String getIssuerUri() {
        return "http://issuer.example.com";
    }
}
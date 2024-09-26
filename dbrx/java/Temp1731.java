import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.web.server.ServerBearerTokenAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.web.server.authentication.ServerBearerTokenAuthenticationToken;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFilterChain;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.security.KeyFactory;
import java.util.Base64;

@Configuration
@EnableWebFluxSecurity
public class Temp1731 {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) throws Exception {
        // Create Auth0 JwtDecoder instance
        String auth0JwkSetUri = "https://your-auth0-domain/.well-known/jwks.json"; // replace with your actual JWK Set URI
        JwtDecoder auth0JwtDecoder = NimbusJwtDecoder.withJwkSetUri(auth0JwkSetUri).build();

        // Create Public/Private key pair based JWT decoder 
        String publicKeyString = "your-public-key-in-PEM-format"; // load your public key here
        publicKeyString = publicKeyString.replaceAll("\\n", "").replaceAll("\\r", "");
        String publicKeyContent = publicKeyString.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "");
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKeyContent));
        KeyFactory kf = KeyFactory.getInstance("RSA");
        RSAPublicKey publicKey = (RSAPublicKey) kf.generatePublic(publicKeySpec);
        com.nimbusds.jwt.proc.DefaultJWTProcessor jwtProcessor = new com.nimbusds.jwt.proc.DefaultJWTProcessor();
        jwtProcessor.setJWTClaimsSetVerifier(new com.nimbusds.jwt.proc.RSASSAVerifier(publicKey));
        JwtDecoder customJwtDecoder = new NimbusJwtDecoder(jwtProcessor);

        // Create AuthenticationManagerResolver that checks both decoders
        AuthenticationManager authenticationManager = (authentication) -> {
            if (!(authentication instanceof JwtAuthenticationToken)) {
                throw new BadCredentialsException("Invalid token");
            }

            String jwtString = ((JwtAuthenticationToken) authentication).getToken().getTokenValue();
            try {
                auth0JwtDecoder.decode(jwtString);
                return authentication;
            } catch (BadCredentialsException e) {
            }

            customJwtDecoder.decode(jwtString);
            return authentication;
        };

        // Configure Spring Security with the AuthenticationManagerResolver
        ServerAuthenticationConverter authenticationConverter = new ServerBearerTokenAuthenticationConverter();
        AuthenticationWebFilter authenticationWebFilter = new AuthenticationWebFilter(authenticationManager);
        authenticationWebFilter.setServerAuthenticationConverter(authenticationConverter);
        authenticationWebFilter.setRequiresAuthenticationMatcher(ServerWebExchangeMatchers.pathMatchers("/**"));

        http.oauth2ResourceServer().jwt().authenticationManager(authenticationManager);
        http.addFilterAt(authenticationWebFilter, SecurityWebFilterChain.class);

        return http.build();
    }
}
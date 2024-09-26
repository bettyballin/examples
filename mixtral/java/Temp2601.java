import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoders;

public class Temp2601 {
    public static void main(String[] args) {

        // Replace this with your public key for the verifier
        String verifier = "your-public-key-here";

        var jwtDecoder = NimbusJwtDecoder
            .withPublicKey(verifier)
            .build();

        // If you have a JWK set
        var jwtDecoderFromOidc = ReactiveJwtDecoders.fromOidcIssuerLocation("https://your-issuer/");

        // Additional code to demonstrate usage can be added here
    }
}
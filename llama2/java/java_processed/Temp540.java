import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoderJwkSupport;

public class Temp540 {
    public static void main(String[] args) {
        Temp540 temp = new Temp540();
        JwtDecoder decoder = temp.jwtDecoder();
        System.out.println("JwtDecoder initialized: " + (decoder != null));
    }

    private JwtDecoder jwtDecoder() {
        String issuerUri = "https://your-issuer-uri.com";  // Replace with actual URI
        NimbusJwtDecoderJwkSupport jwtDecoder = (NimbusJwtDecoderJwkSupport) JwtDecoders.fromOidcIssuerLocation(issuerUri);

        // Additional configuration if needed
        // ...

        return jwtDecoder;
    }
}
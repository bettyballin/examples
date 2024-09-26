import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

public class Temp255 {
    public static void main(String[] args) {
        // Example JWT token (replace this with an actual token for testing)
        String token = "your-jwt-token-here";

        // Example secret key (replace this with your actual secret key)
        String secretKey = "your-secret-key-here";

        // Create a JwtDecoder using the secret key
        JwtDecoder jwtDecoder = NimbusJwtDecoder.withSecretKey(secretKey.getBytes()).build();

        try {
            // Decode the JWT token
            Jwt decodedJwt = jwtDecoder.decode(token);
            
            // Print the decoded JWT claims
            System.out.println("JWT Claims: " + decodedJwt.getClaims());
        } catch (Exception e) {
            System.out.println("Failed to decode JWT: " + e.getMessage());
        }
    }
}
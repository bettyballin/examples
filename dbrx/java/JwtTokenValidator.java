import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Base64;

public class JwtTokenValidator {

    private final Key publicKey;

    public JwtTokenValidator(String publicKey) {
        byte[] byteKey = Base64.getDecoder().decode(publicKey);
        this.publicKey = Keys.hmacShaKeyFor(byteKey);
    }

    public boolean validate(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(publicKey).build().parseClaimsJws(token);
            return true; 
        } catch (SignatureException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String publicKey = "your-base64-encoded-public-key";
        String token = "your-jwt-token";
        
        JwtTokenValidator validator = new JwtTokenValidator(publicKey);
        boolean isValid = validator.validate(token);
        System.out.println("Token is valid: " + isValid);
    }
}
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Temp1051 {
    public static void main(String[] args) {
        String secretKey = "your-secret-key-here";
        long ttlMillis = 60 * 1000; // 1 minute expiration time

        // Generate new JWT token string with user id claim value set to some unique identifier of logged in user account.
        String jwtTokenStr = Jwts.builder()
                .setSubject("userId")
                .setExpiration(java.sql.Timestamp.valueOf(java.time.LocalDateTime.now().plusSeconds(ttlMillis / 1000)))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        System.out.println("Generated JWT Token: " + jwtTokenStr);
    }
}
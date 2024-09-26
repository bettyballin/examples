import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class Temp365 {
    public static void main(String[] args) {

        String token = Jwts.builder().signWith(Keys.secretKeyFor(SignatureAlgorithm.HS256)).compact();
        Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token);
            // Process the claims
            Claims claims = claimsJws.getBody();
            System.out.println(claims);
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}
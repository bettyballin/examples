import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;

public class Temp970 {
    public static void main(String[] args) {
        String token = "your_jwt_token_here";
        Jwt jwtToken = JwtHelper.decode(token);
        Claims claims = Jwts.parser()
            .setSigningKey("your_signing_key".getBytes())
            .parseClaimsJws(jwtToken.getEncoded())
            .getBody();

        String subject = claims.getSubject();
        System.out.println("Subject: " + subject);
    }
}
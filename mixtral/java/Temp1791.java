import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class Temp1791 {

    // Mocked SecurityConstants class to provide necessary constants
    static class SecurityConstants {
        public static final long EXPIRATION_TIME = 864_000_000; // 10 days
        public static final String TOKEN_SECRET = "mySecretKey";
    }

    public static void main(String[] args) {
        String userName = "user"; // Mocked user name for the example

        String token = Jwts.builder()
                .setSubject(userName)
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET)
                .compact();

        System.out.println("Generated Token: " + token);
    }
}
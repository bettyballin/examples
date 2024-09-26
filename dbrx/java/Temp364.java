import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;

public class Temp364 {
    public static void main(String[] args) {

        String secretKey = "your-secret-key";
        long ttlMillis = 60 * 1000; // 1 minute

        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.MINUTE, (int) (ttlMillis / 60000));
        Date expirationTime = calendar.getTime();

        String token = Jwts.builder()
                .setSubject("your-subject")
                .claim("roles", "admin") // optional
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
                .setExpiration(expirationTime)
                .compact();

        System.out.println("Generated Token: " + token);
    }
}
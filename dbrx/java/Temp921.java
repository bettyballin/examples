import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

public class Temp921 {
    private static final String SECRET_KEY = "your_secret_key_here";

    public static void main(String[] args) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            String email = ((UserDetails) authentication.getPrincipal()).getUsername();
            String jwt = Jwts.builder()
                    .setSubject(email)
                    .setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();

            // Here you need to replace with actual HttpServletResponse implementation
            HttpServletResponse response = null;
            response.addHeader("Authorization", "Bearer " + jwt);
        }
    }
}
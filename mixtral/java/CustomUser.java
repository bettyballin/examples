import java.io.Serializable;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class CustomUser implements Serializable {
    private String username;

    // other fields

    public CustomUser(String token) throws Exception {
        Claims claims = Jwts.parser()
            .setSigningKey("secretkey".getBytes())
            .parseClaimsJws(token).getBody();

        this.username = (String) claims.get("preferred_username");

        // other fields
    }

    public String getUsername() {
        return username;
    }

    public static void main(String[] args) {
        try {
            // Replace with an actual JWT token for testing
            String token = "your.jwt.token.here";
            CustomUser user = new CustomUser(token);
            System.out.println("Username: " + user.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
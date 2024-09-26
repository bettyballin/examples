import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.proc.BadJWTException;
import java.text.ParseException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Temp1182 {
    public static void main(String[] args) {
        String idToken = "your_jwt_token_here"; // Replace with your JWT token
        try {
            JWT jwt = JWTParser.parse(idToken);
            JWTClaimsSet claims = jwt.getJWTClaimsSet();
            String nonce = (String) claims.getClaim("nonce");
            org.hamcrest.MatcherAssert.assertThat(nonce, org.hamcrest.Matchers.equalTo("random_string"));
        } catch (ParseException | BadJWTException e) {
            System.out.println("Failed to parse JWT token: " + e.getMessage());
        }
    }
}
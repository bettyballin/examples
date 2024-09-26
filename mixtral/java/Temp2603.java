import java.util.Collections;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class Temp2603 {
    public static void main(String[] args) {
        String jwt = "your_encoded_token_here"; // Replace with your encoded token
        JwtDecoder jwtDecoder = new JwtDecoder(); // Assuming you have a JwtDecoder class
        var claims = jwtDecoder.decode("Bearer " + jwt).getClaims();

        // Now you can use 'claims'
        String username = claims.get("username").toString(); // Assuming the username is in the claims

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                username, null, Collections.emptyList());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}

// Assuming you have a JwtDecoder class
class JwtDecoder {
    public DecodedJWT decode(String token) {
        // Implement token decoding logic here
        return new DecodedJWT();
    }
}

class DecodedJWT {
    public Claims getClaims() {
        // Implement claims extraction logic here
        return new Claims();
    }
}

class Claims {
    public Object get(String key) {
        // Implement claims retrieval logic here, example:
        if ("username".equals(key)) {
            return "sampleUsername"; // Replace with actual logic to get the username
        }
        return null;
    }
}
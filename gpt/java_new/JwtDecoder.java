import org.springframework.util.StringUtils;
import org.springframework.security.oauth2.jwt.JwtException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class JwtDecoder {

    public static String decodeJwt(String jwtToken) throws JwtException {
        if (!StringUtils.hasText(jwtToken)) {
            throw new JwtException("JWT token is null or empty");
        }

        String[] parts = jwtToken.split("\\.");
        if (parts.length != 3) {
            throw new JwtException("JWT token does not have 3 parts");
        }

        String payload = parts[1];
        byte[] decodedBytes = Base64.getUrlDecoder().decode(payload);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
}
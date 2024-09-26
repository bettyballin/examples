import com.fasterxml.jackson.annotation.JsonNaming;
import com.fasterxml.jackson.annotation.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

public class Main {
    public static void main(String[] args) throws Exception {
        // Example usage
        ObjectMapper objectMapper = new ObjectMapper();

        TokenResponseDTO tokenResponseDTO = new TokenResponseDTO("example_token");
        String jsonTokenResponse = objectMapper.writeValueAsString(tokenResponseDTO);
        System.out.println("TokenResponseDTO JSON: " + jsonTokenResponse);

        JWTPayloadDTO jwtPayloadDTO = new JWTPayloadDTO("example_aud", "example_sub", "example_nbf",
                "example_authLevel", "example_iss", 123456789L, 987654321L, "example_nonce", "example_jti");
        String jsonJwtPayload = objectMapper.writeValueAsString(jwtPayloadDTO);
        System.out.println("JWTPayloadDTO JSON: " + jsonJwtPayload);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
class TokenResponseDTO implements Serializable {
    private String idToken;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
class JWTPayloadDTO implements Serializable {
    private String aud;
    private String sub;
    private String nbf;
    private String authLevel;
    private String iss;
    private Long exp;
    private Long iat;
    private String nonce;
    private String jti;
}
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
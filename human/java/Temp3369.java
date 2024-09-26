import java.util.Map;
import com.google.common.collect.ImmutableMap;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;

public class Temp3369 {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) {
        Map<String, String> headers = ImmutableMap.of("kid", "b0ec688af03dd7875116bf6d36c3584256ieirir");
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", "1234567890");
        claims.put("name", "John Doe");
        claims.put("admin", true);

        MacSigner signer = new MacSigner("secret");
        try {
            String jwt = JwtHelper.encode(OBJECT_MAPPER.writeValueAsString(claims), signer, headers).getEncoded();
            System.out.println(jwt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
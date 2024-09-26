import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.Signer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestTokenGenerator {

    private static final Logger log = LoggerFactory.getLogger(TestTokenGenerator.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private Signer signer;

    public TestTokenGenerator() {
        try {
            if (signer == null) {
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                byte[] keySpecBytes = Base64.getDecoder().decode(getKey());
                PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keySpecBytes);
                PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
                signer = new RsaSigner((RSAPrivateKey) privateKey, "SHA512withRSA");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
        TestTokenGenerator gen = new TestTokenGenerator();
        gen.customerJwt("MYUSER");
    }

    public String customerJwt(String userCode) {
        String token = jwt(userCode, "wd.idp.ext.abc.com");
        return token;
    }

    private String jwt(String userCode, String iss) {
        Map<String, Object> claims = new HashMap<>();
        Map<String, String> headers = Map.of("kid", "b0ec688af03dd7875116bf6d36c3584256ieirir");

        claims.put("user_name", userCode);
        claims.put("sub", userCode);
        claims.put("amr", "[aht]");

        String jwt = JwtHelper.encode(OBJECT_MAPPER.writeValueAsString(claims), signer, headers).getEncoded();

        log.info("User: {}, Token: {}, Claims: {}", userCode, jwt, claims);
        return jwt;
    }

    private String getKey() {
        return "YOUR_PRIVATE_KEY_HERE"; // Replace with your actual private key
    }
}
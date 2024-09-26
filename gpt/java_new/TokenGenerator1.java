import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class TokenGenerator1 {

    public String generateCsrfToken(String secretKey, String sessionId) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
        mac.init(secretKeySpec);

        byte[] hmacBytes = mac.doFinal(sessionId.getBytes());
        return Base64.getEncoder().encodeToString(hmacBytes);
    }
}
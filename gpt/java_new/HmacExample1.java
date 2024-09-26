import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class HmacExample1 {
    public static void main(String[] args) {
        try {
            String message = "Sample Text";
            String key = "secret";
            byte[] keyBytes = key.getBytes();

            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(keyBytes, "HmacSHA256");
            sha256_HMAC.init(secret_key);

            byte[] hmacData = sha256_HMAC.doFinal(message.getBytes());
            String hmac = Base64.getEncoder().encodeToString(hmacData);
            System.out.println("HMAC: " + hmac);
        } catch (Exception e) {
            System.err.println("Error");
        }
    }
}
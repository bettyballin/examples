import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Temp34 {
    public static void main(String[] args) {
        try {
            String secret = "your-secret-key";
            String dataToSign = "your-message";

            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] macData = sha256_HMAC.doFinal(dataToSign.getBytes(StandardCharsets.UTF_8));

            String result = Base64.getEncoder().encodeToString(macData);
            System.out.println("HMAC SHA256: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
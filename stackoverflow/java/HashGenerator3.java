import com.google.common.io.BaseEncoding;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HashGenerator3 {
    public static void main(String[] args) {
        try {
            String message = "The message to hash";
            String secret = "secret";

            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);

            final String hash = BaseEncoding.base16().lowerCase().encode(sha256_HMAC.doFinal(message.getBytes()));
            System.out.println(hash);
        } catch (Exception e) {
            System.err.println("Error generating hash: " + e.getMessage());
        }
    }
}
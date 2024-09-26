import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class KeyUtil {
    private static SecretKey b64EncodedStringToSecretKey(String base64encodedKey) {
        byte[] decodedKey = Base64.getDecoder().decode(base64encodedKey);
        return new SecretKeySpec(decodedKey, "AES");
    }
}
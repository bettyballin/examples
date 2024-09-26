import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import org.apache.commons.codec.binary.Base64;

public class Main50 {
    public static void main(String[] args) {
        try {
            String publicK = "your_public_key_base64_string";
            byte[] publicBytes = Base64.decodeBase64(publicK);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = keyFactory.generatePublic(keySpec);
            // Use pubKey as needed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
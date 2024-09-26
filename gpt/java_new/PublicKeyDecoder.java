import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import org.apache.commons.codec.binary.Base64;

public class PublicKeyDecoder {

    public static PublicKey decodePublicKey(String publicK) throws Exception {
        byte[] publicBytes = Base64.decodeBase64(publicK);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    public static void main(String[] args) {
        try {
            String publicK = "..."; // Your Base64-encoded public key string
            PublicKey publicDecoded = decodePublicKey(publicK);
            // Now you have a PublicKey object
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
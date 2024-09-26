import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class Temp2564 {
    public static void main(String[] args) {
        try {
            // Sample base64 encoded private key (replace this with your actual key)
            String base64PrivateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASC...";

            // Decode the base64 encoded private key
            byte[] keyBytes = Base64.getDecoder().decode(base64PrivateKey);
            
            // Generate private key
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
            
            // Initialize Cipher
            Cipher cipher = Cipher.getInstance("RSA/NONE/OAEPPadding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            
            // Your decryption logic here

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
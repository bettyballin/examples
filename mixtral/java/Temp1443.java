import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Temp1443 {
    public static void main(String[] args) {
        try {
            String pubKeyPEM = "YOUR_BASE64_ENCODED_PUBLIC_KEY";
            byte[] decodedKey = Base64.getDecoder().decode(pubKeyPEM);
            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(decodedKey);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);

            // Use the public key as needed
            System.out.println("Public Key: " + pubKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
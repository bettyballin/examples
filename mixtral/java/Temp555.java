import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class Temp555 {
    public static void main(String[] args) {
        String publicK = "YOUR_BASE64_ENCODED_PUBLIC_KEY_HERE";
        
        try {
            byte[] decodedPublicKey = Base64.getDecoder().decode(publicK);
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(decodedPublicKey);

            // Create a KeyFactory instance
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            // Generate the PublicKey
            PublicKey generatedPubicKey = keyFactory.generatePublic(publicKeySpec);
            System.out.println("Public key generated successfully: " + generatedPubicKey);
        } catch (InvalidKeySpecException e) {
            System.out.println("Error generating public key: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General error: " + e.getMessage());
        }
    }
}
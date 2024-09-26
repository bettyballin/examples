import java.security.KeyFactory;
import java.security.spec.ECParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.security.interfaces.ECPublicKey;
import java.util.Base64;

public class Temp480 {
    public static void main(String[] args) {
        try {
            // Example object string, should be replaced with actual object string
            String obj = "exampleObjectString";

            // Base64 encode the object string
            byte[] encodingObj = Base64.getEncoder().encode(obj.getBytes());

            // Create a new ECPublicKey instance from the Base64-encoded string
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(encodingObj));
            ECPublicKey publicKey = (ECPublicKey) keyFactory.generatePublic(keySpec);

            // Print the public key
            System.out.println(publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Temp713 {
    public static void main(String[] args) {
        // Example usage
        String publicKeyStr = "YourBase64EncodedPublicKeyString";
        PublicKey publicKey = strToPublicKey(publicKeyStr);
        if (publicKey != null) {
            System.out.println("Public Key: " + publicKey);
        } else {
            System.out.println("Failed to convert string to public key.");
        }
    }

    public static PublicKey strToPublicKey(String s) {
        try {
            byte[] keyBytes = Base64.getDecoder().decode(s);

            KeyFactory kf = KeyFactory.getInstance("RSA");

            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);

            return kf.generatePublic(spec);
        } catch (Exception e) {
            // Logging the error message
            System.err.println("CIPHER: " + e.getMessage());

            // Return null or throw an exception as per your application's error handling strategy
            return null;
        }
    }
}
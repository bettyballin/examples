import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public class KeyPairValidator {

    public static boolean isValid(KeyFactory factory, PublicKey publicKey) {
        try {
            byte[] encoded = publicKey.getEncoded();
            X509EncodedKeySpec spec = new X509EncodedKeySpec(encoded);
            return factory.generatePublic(spec).equals(publicKey);
        } catch (Exception e) {
            System.err.println("Error validating public key: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        KeyFactory factory = KeyFactory.getInstance("RSA");
        
        // For demonstration, we'll use a Base64-encoded public key string.
        String publicKeyStr = "YOUR_PUBLIC_KEY_IN_BASE64"; // Replace with your actual public key in Base64 format
        byte[] publicKeyBytes = java.util.Base64.getDecoder().decode(publicKeyStr);
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        PublicKey publicKey = factory.generatePublic(publicKeySpec);

        boolean isValid = KeyPairValidator.isValid(factory, publicKey);
        System.out.println(isValid ? "Public key is valid" : "Invalid public key.");
    }
}
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public class KeyPairValidator {

    public static boolean isValid(KeyFactory factory, PublicKey publicKey) {
        try {
            // Try to decode the key using X.509 format.
            byte[] encoded = publicKey.getEncoded();
            X509EncodedKeySpec spec = new X509EncodedKeySpec(encoded);
            return factory.generatePublic(spec).equals(publicKey);
        } catch (Exception e) {
            System.err.println("Error validating public key: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        // Example usage
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        java.security.KeyPairGenerator kpg = java.security.KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        java.security.KeyPair kp = kpg.generateKeyPair();
        PublicKey publicKey = kp.getPublic();
        boolean result = isValid(keyFactory, publicKey);
        System.out.println("Is valid: " + result);
    }
}
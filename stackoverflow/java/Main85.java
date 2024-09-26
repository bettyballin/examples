import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Main85 {
    public static void main(String[] args) {
        try {
            String publicKeyPEM = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEDA0qMRpJwaJyJ4YDciMqWefvr/mwYvF1fKnblJl5DOqAh5XUXkdWvYRDTTs9hPoHfPaNWWC9I0hOGb6+JPNxVw==";
            
            byte[] encoded = Base64.getDecoder().decode(publicKeyPEM);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            PublicKey publicKey = keyFactory.generatePublic(keySpec);
            
            // Use the publicKey object for your purposes
            System.out.println("Public Key: " + publicKey.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
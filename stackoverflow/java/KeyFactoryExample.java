import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

public class KeyFactoryExample {
    public static void main(String[] args) {
        try {
            byte[] privateKeyBytes = {/* your private key bytes here */};

            KeyFactory keyFactory = KeyFactory.getInstance("EdDSA");
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);

            // Use the privateKey object as needed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
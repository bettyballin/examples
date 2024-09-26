import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Temp1242 {
    public static void main(String[] args) {
        try {
            // Generate a KeyPair (for example)
            KeyPair keyPair = generateRSAKeyPair();

            // Encode the private and public keys as Strings
            String privateKeyStr = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());
            String publicKeyStr = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());

            // Decode them back to Key objects when needed
            byte[] decodedPrivateKeyBytes = Base64.getDecoder().decode(privateKeyStr);
            byte[] decodedPublicKeyBytes = Base64.getDecoder().decode(publicKeyStr);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decodedPrivateKeyBytes));
            PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(decodedPublicKeyBytes));

            // Now you can use the private and public keys for encryption/decryption
            System.out.println("Private Key: " + privateKey.toString());
            System.out.println("Public Key: " + publicKey.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static KeyPair generateRSAKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // You can specify the key size here
        return keyPairGenerator.generateKeyPair();
    }
}
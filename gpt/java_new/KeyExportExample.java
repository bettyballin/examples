import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class KeyExportExample {
    public static void main(String[] args) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048); // It's recommended to use at least 2048 for RSA keys
            KeyPair keyPair = kpg.generateKeyPair();

            // Get the encoded form of the public key
            byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
            // Convert the public key to a Base64 encoded string
            String publicKeyBase64 = Base64.getEncoder().encodeToString(publicKeyBytes);
            System.out.println("Public key: " + publicKeyBase64);

            // Get the encoded form of the private key
            byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
            // Convert the private key to a Base64 encoded string
            String privateKeyBase64 = Base64.getEncoder().encodeToString(privateKeyBytes);
            System.out.println("Private key: " + privateKeyBase64);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
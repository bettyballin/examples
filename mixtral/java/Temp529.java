import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Temp529 {
    public static void main(String[] args) {
        try {
            // Generate a key pair for demonstration purposes
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();
            var priv = keyPair.getPrivate();
            var pub = keyPair.getPublic();

            // Convert Private Key
            byte[] privKeyBytes = priv.getEncoded();
            String encodedPrivKey = Base64.getEncoder().encodeToString(privKeyBytes);
            System.out.println("Encoded Private Key: " + encodedPrivKey);

            // Convert Public Key
            byte[] pubKeyBytes = pub.getEncoded();
            String encodedPubKey = Base64.getEncoder().encodeToString(pubKeyBytes);
            System.out.println("Encoded Public Key: " + encodedPubKey);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
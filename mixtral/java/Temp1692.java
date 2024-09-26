import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Temp1692 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
            KeyPair keyPair = kpg.generateKeyPair();

            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            String encodedPublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
            System.out.println("Encoded Public Key: " + encodedPublicKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
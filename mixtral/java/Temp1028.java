import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Temp1028 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
            kpg.initialize(256);

            // generate the keys
            KeyPair myKeys = kpg.generateKeyPair();

            PrivateKey privateKey = myKeys.getPrivate();
            PublicKey publicKey = myKeys.getPublic();

            System.out.println("Private Key: " + privateKey);
            System.out.println("Public Key: " + publicKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
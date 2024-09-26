import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

public class KeyGen {
    public static void main(String[] args) throws Exception {
        // Generate a 2048-bit RSA key pair
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048, new SecureRandom());
        KeyPair kp = kpg.generateKeyPair();

        // Print the public and private keys
        System.out.println("Public key: ");
        PublicKey publicKey = kp.getPublic();
        System.out.println(publicKey.toString());
        System.out.println("\nPrivate key: ");
        PrivateKey privateKey = kp.getPrivate();
        System.out.println(privateKey.toString());
    }
}
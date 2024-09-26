import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;

public class Temp442 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
            // Use NativePRNGNonBlocking for better performance on Linux systems.
            SecureRandom random = SecureRandom.getInstanceStrong();
            gen.initialize(4096, random);
            KeyPair keyPair = gen.generateKeyPair();
            PublicKey pubk = keyPair.getPublic();
            PrivateKey prvk = keyPair.getPrivate();

            System.out.println("Public Key: " + pubk.getEncoded());
            System.out.println("Private Key: " + prvk.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
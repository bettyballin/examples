import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

public class Temp606 {
    public static void main(String[] args) {
        try {
            SecureRandom random = SecureRandom.getInstance("NativePRNGNonBlocking");
            KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
            gen.initialize(4096, random);
            KeyPair keyPair = gen.generateKeyPair();
            PublicKey pubk = keyPair.getPublic();
            PrivateKey prvk = keyPair.getPrivate();
            
            System.out.println("Public Key: " + pubk);
            System.out.println("Private Key: " + prvk);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
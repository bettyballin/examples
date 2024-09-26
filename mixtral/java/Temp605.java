import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;

public class Temp605 {
    public static void main(String[] args) {
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
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
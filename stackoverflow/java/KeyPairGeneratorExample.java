import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class KeyPairGeneratorExample {
    public static void main(String[] args) {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            KeyPair keyPair = generator.generateKeyPair();
            
            // Use the generated keyPair for encryption, decryption, etc.
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
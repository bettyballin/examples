import java.security.*;

public class KeyPairGeneratorExample1 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
            KeyPair keyPair = kpg.generateKeyPair();
            // Use keyPair for encryption, decryption, etc.
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
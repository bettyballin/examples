import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class Temp145 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048); // 2048 is the minimum recommended size for RSA key length.
            KeyPair kp = kpg.generateKeyPair();
            System.out.println("KeyPair generated successfully.");
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Algorithm not found: " + e.getMessage());
        }
    }
}
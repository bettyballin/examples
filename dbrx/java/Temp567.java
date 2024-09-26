import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class Temp567 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
            KeyPair kp = kpg.generateKeyPair();
            System.out.println("KeyPair generated successfully.");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
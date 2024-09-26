import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class Temp522 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            System.out.println("KeyPairGenerator successfully created.");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Algorithm not found: " + e.getMessage());
        }
    }
}
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class Temp521 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            System.out.println("KeyPairGenerator instance created successfully.");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
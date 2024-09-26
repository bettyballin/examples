import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class Main22 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
            // Additional code to use keyGen as needed
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
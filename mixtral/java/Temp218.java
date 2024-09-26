import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;

public class Temp218 {
    public static void main(String[] args) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            System.out.println("KeyFactory instance for RSA created successfully.");
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
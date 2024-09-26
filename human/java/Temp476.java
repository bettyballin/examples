import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;

public class Temp476 {
    public static void main(String[] args) {
        try {
            String password = "your_password"; // Example password
            byte[] encryptionKeySalt = new byte[16]; // Example salt
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

            KeySpec spec = new PBEKeySpec(password.toCharArray(), encryptionKeySalt, 12345, 256);
            SecretKey encryptionKey = factory.generateSecret(spec);

            // Use the encryptionKey as needed
            System.out.println("Encryption Key: " + encryptionKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
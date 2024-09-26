import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Temp2996 {
    public static void main(String[] args) {
        try {
            String password = "MyPassword";
            byte[] salt = "12345678".getBytes(); // Example salt, should be securely generated
            int iterations = 65536;
            int keyLength = 256;

            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] key = factory.generateSecret(spec).getEncoded();

            String encodedKey = Base64.getEncoder().encodeToString(key);
            System.out.println("Derived key: " + encodedKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class Temp516 {
    public static void main(String[] args) {
        // Sample data for demonstration purposes
        char[] password = "password".toCharArray();
        byte[] salt = "12345678".getBytes();
        int iterations = 10000;

        try {
            // Create PBEKeySpec with the specified parameters
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, 256);

            // Generate the secret key
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] secretKey = skf.generateSecret(spec).getEncoded();

            // Print the generated key
            System.out.println(Base64.getEncoder().encodeToString(secretKey));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}
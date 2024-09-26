import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Temp679 {
    public static void main(String[] args) {
        try {
            char[] password = "password".toCharArray(); // Example password
            byte[] salt = "salt".getBytes(); // Example salt
            int iterations = 65536; // Example iteration count

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            SecretKey aesKey = factory.generateSecret(new PBEKeySpec(password, salt, iterations, 256));
            
            // Print out the algorithm of the generated key
            System.out.println("Algorithm: " + aesKey.getAlgorithm());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}
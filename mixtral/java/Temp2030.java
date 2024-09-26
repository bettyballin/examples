import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Temp2030 {
    public static void main(String[] args) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] saltBytes = "randomSalt".getBytes(); // replace with your salt
            int iterations = 10000;  // number of iterations
            char[] passwordChars = "somePassword".toCharArray();
            
            PBEKeySpec spec = new PBEKeySpec(passwordChars, saltBytes, iterations, 256);
            SecretKey secretKey = factory.generateSecret(spec);
            byte[] keyBytes = secretKey.getEncoded();
            
            // Print the resulting key bytes
            System.out.println(java.util.Base64.getEncoder().encodeToString(keyBytes));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}
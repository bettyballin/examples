import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class PBKDF2 {
    public static void main(String[] args) {
        String password = "iamtwentycharacterss"; // Your password
        String salt = "50.eGIYr3ZpxpWw67utH17s/A=="; // Your salt
        int iterations = 50; // The number of PBKDF2 iterations
        int keyLength = 256; // Key length in bits
        
        try {
            byte[] saltBytes = Base64.getDecoder().decode(salt);
            KeySpec spec = new PBEKeySpec(password.toCharArray(), saltBytes, iterations, keyLength);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            
            String key = String.format("%032x", new BigInteger(1, hash));
            System.out.println(key);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}
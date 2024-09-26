import javax.crypto.KeyGenerator;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;

public class CryptoExample1 {
    public static void main(String[] args) {
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256, random); // Assuming 256-bit key size is desired
            // Continue with the use of keyGen...
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Temp245 {
    public static void main(String[] args) {
        try {
            String key = generateAesKey(128);
            System.out.println("Generated Key: " + key);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Failed to generate AES key: " + e.getMessage());
        }
    }

    public static String generateAesKey(int length) throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(length);
        SecretKey secretKey = keyGen.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }
}
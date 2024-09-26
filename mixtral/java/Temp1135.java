import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.nio.charset.StandardCharsets;

public class Temp1135 {
    public static void main(String[] args) {
        try {
            SecretKey key = generateKey("password", "salt");
            System.out.println("Key generated successfully: " + key);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    public static SecretKey generateKey(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        char[] passChar = password.toCharArray();
        byte[] saltBytes = salt.getBytes(StandardCharsets.UTF_8);

        int iterations = 1024;

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        PBEKeySpec keySpec = new PBEKeySpec(passChar, saltBytes, iterations, 16 * 8);

        return factory.generateSecret(keySpec);
    }
}
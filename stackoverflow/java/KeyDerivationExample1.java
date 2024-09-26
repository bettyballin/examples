import javax.crypto.SecretKeyFactory;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;

public class KeyDerivationExample1 {
    public static byte[] deriveKey(char[] password) throws Exception {
        int iterationCount = 1000;
        int saltLength = 32;
        int keyLength = 256;
        byte[] salt = new byte[saltLength];

        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);

        KeySpec keySpec = new PBEKeySpec(password, salt, iterationCount, keyLength);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] keyBytes = keyFactory.generateSecret(keySpec).getEncoded();
        SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");

        return secretKey.getEncoded();
    }
}
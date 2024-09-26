import javax.crypto.SecretKeyFactory;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;

public class KeyGenerator {
    public byte[] generateKey(char[] password, byte[] salt, int iterations, int keyLength) throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
        SecretKey secretKey = factory.generateSecret(spec);
        return secretKey.getEncoded();
    }
}
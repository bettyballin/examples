import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class KeyGenerator {
    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        byte[] keyBytes = new byte[16];
        random.nextBytes(keyBytes);
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        // Use the key for your encryption process
    }
}
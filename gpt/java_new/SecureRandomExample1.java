import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;

public class SecureRandomExample1 {
    public static void main(String[] args) {
        SecureRandom secureRandom = null;
        byte[] randomBytes = new byte[16];
        try {
            secureRandom = SecureRandom.getInstanceStrong();
            secureRandom.nextBytes(randomBytes);
        } catch (NoSuchAlgorithmException e) {
            secureRandom = new SecureRandom();
            secureRandom.nextBytes(randomBytes);
        }
    }
}
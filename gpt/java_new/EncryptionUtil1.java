import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.security.Key;

public class EncryptionUtil1 {
    private static final String ALGORITHM = "AES/ECB/PKCS5PADDING";
    private Key secretKey;

    public EncryptionUtil1(Key secretKey) {
        this.secretKey = secretKey;
    }

    public String encrypt(String string) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encrypted = cipher.doFinal(string.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Usage example:
    public static void main(String[] args) {
        String key = "1234567812345678"; // Example key. Use your own key with proper length.
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        EncryptionUtil1 encrypter = new EncryptionUtil1(secretKey);
        String encrypted = encrypter.encrypt("Hello World");
        System.out.println(encrypted);
    }
}
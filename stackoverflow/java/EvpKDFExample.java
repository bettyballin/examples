import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class EvpKDFExample {

    public static void main(String[] args) {
        // Example usage
        String password = "password";
        int keySize = 256;
        int ivSize = 128;
        byte[] saltBytes = new byte[16]; // Example salt. In real case, it should be a proper random salt.

        try {
            byte[] key = new byte[keySize / 8];
            byte[] iv = new byte[ivSize / 8];
            EvpKDF(password.getBytes(StandardCharsets.UTF_8), keySize, ivSize, saltBytes, key, iv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void EvpKDF(byte[] password, int keySize, int ivSize, byte[] salt, byte[] key, byte[] iv)
            throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        PBEKeySpec spec = new PBEKeySpec(new String(password, StandardCharsets.UTF_8).toCharArray(), salt, 1000, keySize + ivSize);

        SecretKey secretKey = factory.generateSecret(spec);
        byte[] keyIvCombined = secretKey.getEncoded();

        System.arraycopy(keyIvCombined, 0, key, 0, keySize / 8);
        System.arraycopy(keyIvCombined, keySize / 8, iv, 0, ivSize / 8);

        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        // Use secretKeySpec and ivParameterSpec for encryption/decryption
    }
}
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Base64;

public class ProductKeyGenerator {

    private static final String ALGORITHM = "AES";

    public static String encrypt(String value, String key) throws Exception {
        Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedValue = cipher.doFinal(value.getBytes());
        return Base64.getEncoder().encodeToString(encryptedValue);
    }

    public static String decrypt(String value, String key) throws Exception {
        Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decryptedValue = cipher.doFinal(Base64.getDecoder().decode(value));
        return new String(decryptedValue);
    }

    public static void main(String[] args) {
        try {
            String key = "1234567812345678"; // 128 bit key
            String originalValue = "This is a secret message";
            String encryptedValue = encrypt(originalValue, key);
            String decryptedValue = decrypt(encryptedValue, key);

            System.out.println("Original Value: " + originalValue);
            System.out.println("Encrypted Value: " + encryptedValue);
            System.out.println("Decrypted Value: " + decryptedValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
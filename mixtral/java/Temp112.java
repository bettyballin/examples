import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Temp112 {

    private static SecretKey secretKey;
    private static Cipher cipher;

    static {
        try {
            secretKey = KeyGenerator.getInstance("AES").generateKey();
            cipher = Cipher.getInstance("AES");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            String originalText = "Hello, World!";
            String encryptedText = encrypt(originalText);
            System.out.println("Encrypted Text      = " + encryptedText);

            String decryptedText = decrypt(encryptedText);
            System.out.println("Decrypted Text      = " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String plainText) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encodedText) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] cipherBytes = Base64.getDecoder().decode(encodedText);
        return new String(cipher.doFinal(cipherBytes), "UTF-8");
    }
}
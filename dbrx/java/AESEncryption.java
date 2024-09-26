import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

public class AESEncryption {
    private static SecretKey secKey;
    private static IvParameterSpec ivspec;

    public static void main(String[] args) throws Exception {
        // Initialize secret key and IV
        String password = "i15646dont6321wanna";
        byte[] salt = "ahhalkdjfslk3205jlk3m4ljdfa85l".getBytes(StandardCharsets.UTF_8);
        int iterationCount = 65536;
        int keyLength = 256;

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterationCount, keyLength);
        secKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

        byte[] ivBytes = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ivspec = new IvParameterSpec(ivBytes);

        // Encrypt and decrypt data
        String originalText = "1010000014";
        System.out.println("Original Text: " + originalText);
        String encryptedText = encrypt(originalText);
        System.out.println("Encrypted Text: " + encryptedText);
        String decryptedText = decrypt(encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }

    public static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, secKey, ivspec);
        byte[] encrypted = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String base64Data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secKey, ivspec);
        byte[] decoded = Base64.getDecoder().decode(base64Data);
        byte[] decrypted = cipher.doFinal(decoded);
        return new String(decrypted, StandardCharsets.UTF_8);
    }
}
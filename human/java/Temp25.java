import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Temp25 {
    public static void main(String[] args) {
        try {
            // Example values (These should be replaced with actual secret key, IV, and ciphertext)
            String secretKey = "0123456789abcdef"; // 16-byte key for AES-128
            String ivString = "1234567890abcdef"; // 16-byte IV
            String encryptedText = "Base64EncodedCiphertext"; // Base64 encoded ciphertext

            // Decode Base64 encoded ciphertext and initialize key/IV
            byte[] iv = ivString.getBytes(StandardCharsets.UTF_8);
            byte[] ciphertext = Base64.getDecoder().decode(encryptedText);
            SecretKeySpec secret = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");

            // Decrypt the message
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(iv));
            String plaintext = new String(cipher.doFinal(ciphertext), StandardCharsets.UTF_8);
            System.out.println(plaintext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
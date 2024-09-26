import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp634 {
    public static void main(String[] args) {
        try {
            String key = "1234567890123456"; // 16-byte key for AES-128
            String encryptedText = "encryptedSampleText"; // Example encrypted text

            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decodedEncryptedText = Base64.getDecoder().decode(encryptedText);
            byte[] decryptedBytes = cipher.doFinal(decodedEncryptedText);
            String decryptedText = new String(decryptedBytes);

            System.out.println("Decrypted Text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Arrays;

public class Temp942 {
    public static void main(String[] args) {
        byte[] initializer = new byte[16];
        Arrays.fill(initializer, (byte) 0);
        String encrypt = encrypt("plainText", initializer);
        System.out.println("Encrypted Text: " + encrypt);
    }

    public static String encrypt(String plainText, byte[] key) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            // Use ECB mode for simplicity but consider using a more secure mode like GCM or CBC

            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] cipherText = cipher.doFinal(plainText.getBytes("UTF8"));
            String encryptedString = Base64.getEncoder().encodeToString(cipherText);
            return encryptedString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
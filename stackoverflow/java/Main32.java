import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Main32 {
    public static void main(String[] args) {
        try {
            String key = "1234567890123456"; // 16-byte key for AES
            SecretKeySpec encryptionKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");

            // Assuming plaintext is a byte array of at least 16 bytes
            // Since NoPadding is used, the plaintext length must be a multiple of 16 bytes
            byte[] plaintext = new byte[16]; 

            cipher.init(Cipher.ENCRYPT_MODE, encryptionKey);
            byte[] encryptedData = cipher.doFinal(plaintext);

            // Encrypted data processing...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
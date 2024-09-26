import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp937 {
    public static void main(String[] args) throws Exception {
        // Example key and data
        byte[] key = "1234567890123456".getBytes(); // 16-byte key for AES-128
        byte[] dataToEncrypt = "Hello, World!".getBytes();

        // Generate secret key
        SecretKey secret = new SecretKeySpec(key, "AES");

        // Create cipher instance
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        // Encrypt
        cipher.init(Cipher.ENCRYPT_MODE, secret);
        byte[] encryptedData = cipher.doFinal(dataToEncrypt);
        System.out.println("Encrypted Data: " + Base64.getEncoder().encodeToString(encryptedData));

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, secret);
        byte[] decryptedData = cipher.doFinal(encryptedData);
        System.out.println("Decrypted Data: " + new String(decryptedData));
    }
}
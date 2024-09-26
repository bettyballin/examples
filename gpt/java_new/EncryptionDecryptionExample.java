import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import android.util.Base64;

public class EncryptionDecryptionExample {
    public static void main(String[] args) throws Exception {
        // Assuming 'secretKey_AES' is already initialized and 'message' is the string to encrypt
        SecretKey secretKey_AES = null; // Placeholder initialization
        String message = "Your message here";

        // Encryption
        Cipher encryptCipher = Cipher.getInstance("AES");
        encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey_AES);
        byte[] encrypted = encryptCipher.doFinal(message.getBytes("UTF-8"));
        String encryptedMessage = Base64.encodeToString(encrypted, Base64.DEFAULT);

        // Decryption
        Cipher decryptCipher = Cipher.getInstance("AES");
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKey_AES);
        byte[] encryptedBytes = Base64.decode(encryptedMessage, Base64.DEFAULT);
        byte[] decrypted = decryptCipher.doFinal(encryptedBytes);
        String decryptedMessage = new String(decrypted, "UTF-8");
    }
}
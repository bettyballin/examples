import javax.crypto.*;
import java.security.*;
import org.apache.commons.codec.binary.Base64;

public class Temp452 {
    public static void main(String[] args) {
        try {
            // Generate a key for the AES algorithm
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();

            // Create a cipher using the AES algorithm
            Cipher cipher = Cipher.getInstance("AES");

            // Initialize the cipher for encryption
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Encrypt a sample message
            String message = "Hello, World!";
            byte[] encrypted = cipher.doFinal(message.getBytes());
            String encoded = Base64.encodeBase64String(encrypted);

            System.out.println("Encrypted message: " + encoded);

            // Initialize the cipher for decryption
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            // Decode and decrypt the message
            byte[] decoded = Base64.decodeBase64(encoded);
            byte[] decrypted = cipher.doFinal(decoded);
            String decryptedMessage = new String(decrypted);

            System.out.println("Decrypted message: " + decryptedMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
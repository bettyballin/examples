import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp3286 {
    public static void main(String[] args) {
        try {
            // Define the message to encrypt
            String message = "This is a secret message";

            // Generate a key for AES encryption
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256); // For example, using 256-bit AES
            SecretKey secretKey = keyGen.generateKey();

            // Create the cipher object
            Cipher cipher = Cipher.getInstance("AES");

            // Encrypt the message
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(message.getBytes());
            String encryptedMessage = Base64.getEncoder().encodeToString(encryptedBytes);

            // Print the encrypted message
            System.out.println("Encrypted Message: " + encryptedMessage);

            // Decrypt the message
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
            String decryptedMessage = new String(decryptedBytes);

            // Print the decrypted message
            System.out.println("Decrypted Message: " + decryptedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
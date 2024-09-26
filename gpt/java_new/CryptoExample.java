import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class CryptoExample {
    public static void main(String[] args) {
        try {
            // Create a KeyGenerator instance for the AES algorithm
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");

            // Generate a SecretKey
            SecretKey secretKey = keyGenerator.generateKey();

            // Create a Cipher instance for AES in Electronic Codebook mode with PKCS#5 padding
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            // Initialize the Cipher in ENCRYPT_MODE with the generated secretKey
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Create a plaintext message
            String message = "This is a secret message";
            byte[] plaintext = message.getBytes();

            // Perform encryption
            byte[] ciphertext = cipher.doFinal(plaintext);

            // Print out the ciphertext
            System.out.println("Encrypted text: " + new String(ciphertext));

            // Initialize the Cipher in DECRYPT_MODE
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            // Perform decryption
            byte[] decryptedText = cipher.doFinal(ciphertext);

            // Print out the decrypted text
            System.out.println("Decrypted text: " + new String(decryptedText));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
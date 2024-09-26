import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class Temp1350 {

    public static void main(String[] args) {
        try {
            // Generate a temporary key. In practice, you would save this key.
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128); // The AES key size in number of bits
            SecretKey secretKey = keyGenerator.generateKey();

            // Create a cipher using that key to initialize it
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Sample input string
            String input = "Hello, World!";
            byte[] encryptedOut = cipher.doFinal(input.getBytes("UTF-8"));

            // Decrypt the message
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            String decryptedOut = new String(cipher.doFinal(encryptedOut), "UTF-8");

            System.out.println("Encrypted (Base64): " + Base64.getEncoder().encodeToString(encryptedOut));
            System.out.println("Decrypted: " + decryptedOut);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
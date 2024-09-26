import javax.crypto.*;
import java.security.*;
import org.apache.commons.codec.binary.Hex;

public class Temp1117 {
    public static void main(String[] args) {
        try {
            // Generate a key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair pair = keyGen.generateKeyPair();

            // Create a Cipher object and initialize it for encryption
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());

            // Encrypt the message
            String message = "Hello, World!";
            byte[] encryptedMessage = cipher.doFinal(message.getBytes());
            System.out.println("Encrypted Message: " + Hex.encodeHexString(encryptedMessage));

            // Initialize the same cipher object for decryption
            cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
            byte[] decryptedMessage = cipher.doFinal(encryptedMessage);

            // Print the decrypted message
            System.out.println("Decrypted Message: " + new String(decryptedMessage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
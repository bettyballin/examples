import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp1150 {

    public static void main(String[] args) {
        try {
            // Example key and data, replace with actual key and data
            String keyString = "s3cr3tK3y1234567"; // Example key (must be 16 bytes for AES-128)
            String encryptedDataString = "U2FsdGVkX1+gQd0N3Y9P1g=="; // Example base64 encoded encrypted data

            // Decode the encrypted data
            byte[] encryptedData = Base64.getDecoder().decode(encryptedDataString);

            // Create key
            SecretKey key = new SecretKeySpec(keyString.getBytes(), "AES");

            // Initialize cipher
            Cipher pbeCipher = Cipher.getInstance("AES");
            pbeCipher.init(Cipher.DECRYPT_MODE, key);

            // Decrypt data
            byte[] decryptedData = pbeCipher.doFinal(encryptedData);

            // Print decrypted data
            System.out.println(new String(decryptedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
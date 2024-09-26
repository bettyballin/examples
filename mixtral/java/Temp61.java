import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Temp61 {
    public static void main(String[] args) {
        try {
            // Generate a key for the example
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();

            // Create a Cipher instance
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Encrypt some data
            byte[] inputData = "Hello, World!".getBytes();
            cipher.update(inputData);

            // Finalize the encryption
            byte[] signature = cipher.doFinal();
            System.out.println("Encryption successful, signature: " + new String(signature));
        } catch (BadPaddingException e) {
            // Handle exception here like closing UDP socket or logging error
            System.err.println("BadPaddingException: " + e.getMessage());
        } catch (Exception e) {
            // Handle other potential exceptions
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
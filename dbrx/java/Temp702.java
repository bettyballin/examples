import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;

public class Temp702 {
    public static void main(String[] args) {
        try {
            // Generate a key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // 192 or 256 bits as per your requirement
            SecretKey secretKey = keyGen.generateKey();

            // Create a cipher with the specified algorithm
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            // Generate an initialization vector (IV)
            byte[] iv = new byte[cipher.getBlockSize()];
            SecureRandom random = new SecureRandom();
            random.nextBytes(iv);
            IvParameterSpec ivParams = new IvParameterSpec(iv);

            // Sample data to encrypt
            byte[] dataToEncrypt = "Hello, World!".getBytes(StandardCharsets.UTF_8);

            // For encryption:
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParams);
            byte[] encryptedData = cipher.doFinal(dataToEncrypt);

            // For decryption:
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParams);
            byte[] decryptedData = cipher.doFinal(encryptedData);

            // Output the results
            System.out.println("Original Data: " + new String(dataToEncrypt, StandardCharsets.UTF_8));
            System.out.println("Encrypted Data: " + java.util.Arrays.toString(encryptedData));
            System.out.println("Decrypted Data: " + new String(decryptedData, StandardCharsets.UTF_8));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
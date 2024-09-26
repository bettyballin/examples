import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Arrays;

public class Temp322 {
    public static void main(String[] args) {
        try {
            // Generate AES key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();

            // Initialize IV and cipher
            SecureRandom secureRandom = new SecureRandom();
            byte[] iv = new byte[16];
            secureRandom.nextBytes(iv);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

            // Encrypt message
            String message = "Decryption Works -- using multiple blocks";
            byte[] encryptedMessage = cipher.doFinal(message.getBytes());

            // Save key, IV, and encrypted message to file
            try (FileOutputStream fos = new FileOutputStream("test.aes")) {
                fos.write(secretKey.getEncoded());
                fos.write(iv);
                fos.write(encryptedMessage);
            }

            System.out.println("Encryption complete, data saved to test.aes");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
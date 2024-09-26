import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Temp574 {
    public static void main(String[] args) {
        try {
            // Generate a secret key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();

            // Generate an initialization vector (IV)
            byte[] iv = new byte[16]; // AES block size is 16 bytes
            SecureRandom random = new SecureRandom();
            random.nextBytes(iv);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);

            // Get the cipher instance
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

            // Print success message
            System.out.println("Cipher initialized successfully!");

        } catch (NoSuchAlgorithmException | javax.crypto.NoSuchPaddingException |
                 java.security.InvalidKeyException | java.security.InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }
}
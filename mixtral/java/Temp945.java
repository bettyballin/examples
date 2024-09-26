import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class Temp945 {
    public static void main(String[] args) {
        try {
            // Generate a secret key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // for example
            SecretKey secretKey = keyGen.generateKey();

            // Initialize an IV
            IvParameterSpec iv = new IvParameterSpec("0123456789ABCDEF".getBytes());

            // Encrypt the text
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
            byte[] plainText = "Hello, World!".getBytes(); // Example plain text
            byte[] cipherText = cipher.doFinal(plainText);

            // Print the cipher text
            System.out.println(new String(cipherText));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
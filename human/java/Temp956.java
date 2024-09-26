import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Temp956 {
    public static void main(String[] args) {
        try {
            String string = "Hello, World!";
            
            // Generate a temporary key for encryption
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();
            
            // Create a Cipher instance for AES encryption
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            
            // Encrypt the string
            byte[] encryptedBytes = cipher.doFinal(string.getBytes());
            
            // Encode the encrypted bytes using Base64
            String encodedString = Base64.getMimeEncoder().encodeToString(encryptedBytes);
            
            // Print the result
            System.out.println(encodedString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
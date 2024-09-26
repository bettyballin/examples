import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Temp66 {
    public static void main(String[] args) {
        try {
            // Generate a key for the AES encryption
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // 192 and 256 bits may not be available
            SecretKey secretKey = keyGen.generateKey();
            
            // Initialize the cipher for encryption
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            
            int plaintext = 42; // your sequential integer
            byte[] plaintextBytes = Integer.toString(plaintext).getBytes();
            byte[] encrypted = cipher.doFinal(plaintextBytes);
            
            // Print the encrypted bytes
            System.out.println("Encrypted bytes: " + java.util.Arrays.toString(encrypted));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
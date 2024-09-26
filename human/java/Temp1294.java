import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp1294 {
    public static void main(String[] args) {
        try {
            String message = "message";
            String passphrase = "passphrase";
            
            // Generate a key based on the passphrase
            byte[] key = passphrase.getBytes("UTF-8");
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            
            // Create a cipher instance
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            
            // Encrypt the message
            byte[] encryptedMessage = cipher.doFinal(message.getBytes("UTF-8"));
            String encryptedMessageBase64 = Base64.getEncoder().encodeToString(encryptedMessage);
            
            System.out.println("Encrypted message: " + encryptedMessageBase64);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
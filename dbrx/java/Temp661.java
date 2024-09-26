import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp661 {
    public static void main(String[] args) {
        try {
            String message = "Message";
            String secretPassphrase = "Secret Passphrase";

            // Generate a key from the secret passphrase
            byte[] key = secretPassphrase.getBytes("UTF-8");
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

            // Encrypt the message
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(message.getBytes("UTF-8"));
            String encrypted = Base64.getEncoder().encodeToString(encryptedBytes);

            System.out.println("Encrypted message: " + encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
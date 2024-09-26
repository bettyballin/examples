import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main86 {
    public static void main(String[] args) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256); // You can use 128, 192, or 256 bits
            SecretKey secretKey = keyGenerator.generateKey();
            // Use the secretKey for encryption/decryption
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
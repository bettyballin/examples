import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Temp67 {
    public static void main(String[] args) {
        try {
            // Generate a secret key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // for example
            SecretKey sk = keyGen.generateKey();

            // Initialize the cipher for encryption
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, sk);
            
            // Encrypt a sample message
            byte[] message = "Hello, World!".getBytes();
            byte[] encrypted = cipher.doFinal(message);

            // Initialize the cipher for decryption
            cipher.init(Cipher.DECRYPT_MODE, sk);
            byte[] decrypted = cipher.doFinal(encrypted);

            System.out.println("Decrypted message: " + new String(decrypted));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
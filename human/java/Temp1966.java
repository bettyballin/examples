import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;

public class Temp1966 {
    public static void main(String[] args) {
        try {
            // Generate a secret key
            char[] password = "password".toCharArray(); // Example password
            byte[] salt = new byte[16]; // Example salt
            KeySpec spec = new PBEKeySpec(password, salt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            SecretKey secretKey = factory.generateSecret(spec);

            // Initialize the cipher
            Cipher c = Cipher.getInstance("PBEWithHmacSHA256AndAES_128");
            c.init(Cipher.ENCRYPT_MODE, secretKey);

            // Example data to encrypt
            byte[] dataToEncrypt = "Hello, World!".getBytes();
            byte[] encryptedData = c.doFinal(dataToEncrypt);

            // Print encrypted data
            System.out.println(new String(encryptedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
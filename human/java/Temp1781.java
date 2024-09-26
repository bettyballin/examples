import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;

public class Temp1781 {
    public static void main(String[] args) {
        try {
            // Generate a secret key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();

            // Initialize the cipher
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Encrypt something (example)
            String plainText = "Hello, World!";
            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
            System.out.println("Encrypted text: " + new String(encryptedBytes));
        } catch (NoSuchAlgorithmException | InvalidKeyException | javax.crypto.NoSuchPaddingException | javax.crypto.IllegalBlockSizeException | javax.crypto.BadPaddingException e) {
            e.printStackTrace();
        }
    }
}
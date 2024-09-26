import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Temp1431 {
    public static void main(String[] args) {
        try {
            // Generate a secret key for AES encryption/decryption.
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // 192 and 256 bits may not be available due to export restrictions
            SecretKey secretKey = keyGen.generateKey();

            // Initialize the Cipher with ECB mode and PKCS5Padding
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            // Initialize the encryption mode.
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Data to encrypt
            String data = "This is some data to encrypt";
            byte[] dataToEncrypt = data.getBytes();

            // Perform encryption
            byte[] encryptedData = cipher.doFinal(dataToEncrypt);

            // Print encrypted data in hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (byte b : encryptedData) {
                sb.append(String.format("%02X ", b));
            }
            System.out.println("Encrypted Data: " + sb.toString());

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }
}
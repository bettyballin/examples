import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.BadPaddingException;

public class Temp282 {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // Example key and data for demonstration purposes
        String keyString = "thisisasecretkey12345678"; // AES key must be 16, 24 or 32 bytes long
        String encryptedDataString = "N2QyZTEyZWY0ZTAzMjUyZA==";

        // Convert key and data to byte arrays
        byte[] keyBytes = keyString.getBytes();
        byte[] encryptedData = Base64.getDecoder().decode(encryptedDataString);

        // Create secret key
        SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");

        // Initialize the cipher for decryption
        Cipher decryptCipher = Cipher.getInstance("AES");
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Decrypt the data
        byte[] decryptedData = decryptCipher.doFinal(encryptedData);

        // Print the decrypted data
        System.out.println("Decrypted Data: " + new String(decryptedData));
    }
}
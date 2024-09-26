import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Temp536 {
    public static void main(String[] args) {
        try {
            // Example initialization vector and encrypted data
            byte[] initializationVector = Base64.getDecoder().decode("AAAAAAAAAAAAAAAAAAAAAA==");
            byte[] encryptedData = Base64.getDecoder().decode("encrypted data here");
            
            // Example key (must be 16 bytes for AES-128)
            byte[] key = "1234567890123456".getBytes(StandardCharsets.UTF_8);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            IvParameterSpec ivspec = new IvParameterSpec(initializationVector); // Use the same IV as used during encryption.
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivspec);
            byte[] decryptedData = cipher.doFinal(encryptedData);

            // Convert decrypted data to a string
            String decryptedText = new String(decryptedData, StandardCharsets.UTF_8);
            System.out.println("Decrypted text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
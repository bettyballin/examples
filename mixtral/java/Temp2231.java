import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class Temp2231 {
    public static void main(String[] args) {
        try {
            // Example encrypted message and AES key for demonstration purposes
            String encryptedMessageBase64 = "encrypted message from file";
            byte[] aesKeyBytes = Base64.getDecoder().decode("your_base64_encoded_aes_key");

            // Decode the encrypted message from Base64
            byte[] encryptedMessageWithIV = Base64.getDecoder().decode(encryptedMessageBase64);

            // Extract the IV (first 16 bytes)
            IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(encryptedMessageWithIV, 0, 16));

            // Extract the encrypted message (remaining bytes after the IV)
            byte[] encryptedMessage = Arrays.copyOfRange(encryptedMessageWithIV, 16, encryptedMessageWithIV.length);

            // Create the AES key specification
            SecretKeySpec aesKeySpec = new SecretKeySpec(aesKeyBytes, "AES");

            // Create and initialize the cipher for decryption
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, aesKeySpec, iv);

            // Decrypt the message
            byte[] decryptedMsgBytes = cipher.doFinal(encryptedMessage);

            // Convert the decrypted bytes to a string
            String decryptedMessage = new String(decryptedMsgBytes);
            System.out.println("Decrypted message: " + decryptedMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
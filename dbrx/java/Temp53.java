import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp53 {
    public static void main(String[] args) throws Exception {
        // Example data for demonstration
        String extractedIVBase64 = "MTIzNDU2Nzg5MGFiY2RlZg=="; // Base64 encoded IV
        String keyBase64 = "MTIzNDU2Nzg5MGFiY2RlZg=="; // Base64 encoded key
        String encryptedMessageBase64 = "U2FtcGxlRW5jcnlwdGVkTWVzc2FnZQ=="; // Base64 encoded encrypted message

        // Decode base64 encoded values
        byte[] extractedIV = Base64.getDecoder().decode(extractedIVBase64);
        byte[] key = Base64.getDecoder().decode(keyBase64);
        byte[] encryptedMessage = Base64.getDecoder().decode(encryptedMessageBase64);

        // Create IvParameterSpec and SecretKeySpec
        IvParameterSpec ivParameterSpecForDecryption = new IvParameterSpec(extractedIV);
        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");

        // Initialize Cipher for decryption
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpecForDecryption);

        // Decrypt the message
        byte[] decryptedMessage = cipher.doFinal(encryptedMessage);

        // Print the decrypted message
        System.out.println(new String(decryptedMessage, "UTF-8"));
    }
}
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp2177 {
    public static void main(String[] args) throws Exception {
        // Sample key and encrypted message for demonstration purposes
        String keyString = "0123456789abcdef"; // 128 bit key
        String encryptedMessageBase64 = "CiphertextHereInBase64"; // Replace with actual encrypted message

        // Convert the base64 encoded strings to byte arrays
        byte[] keyBytes = keyString.getBytes();
        byte[] encryptedMessage = Base64.getDecoder().decode(encryptedMessageBase64);

        // Generate the secret key and initialize the cipher
        SecretKey desKey = new SecretKeySpec(keyBytes, "DES");
        Cipher desCipher = Cipher.getInstance("DES");

        // Decrypt the message
        desCipher.init(Cipher.DECRYPT_MODE, desKey);
        byte[] decryptedMessage = desCipher.doFinal(encryptedMessage);

        // Print the decrypted message
        System.out.println(new String(decryptedMessage));
    }
}
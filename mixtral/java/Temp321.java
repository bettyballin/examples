import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

class Crypto {
    public SecretKeySpec hashPhrase() {
        // Placeholder for actual key generation logic
        String key = "0123456789abcdef"; // Example key (16 bytes)
        return new SecretKeySpec(key.getBytes(), "AES");
    }
}

public class Temp321 {
    public static void main(String[] args) {
        Temp321 temp = new Temp321();
        String encryptedText = "YourBase64EncodedStringHere"; // Replace with actual Base64 encoded string
        String decryptedText = temp.decrypt(encryptedText);
        System.out.println("Decrypted text: " + decryptedText);
    }

    public String decrypt(String inputBase64Encoded) {
        try {
            Crypto crypto = new Crypto();

            // Convert the Base64 string back to bytes
            byte[] encryptedBytes = Base64.getDecoder().decode(inputBase64Encoded);

            SecretKeySpec key = crypto.hashPhrase();

            Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");

            // Initialize the cipher for decryption
            aes.init(Cipher.DECRYPT_MODE, key);

            return new String(aes.doFinal(encryptedBytes));
        } catch (Exception e) {
            throw new RuntimeException("Failed during decryption", e);
        }
    }
}
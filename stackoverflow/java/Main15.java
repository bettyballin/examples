// Java does not have a direct equivalent to the Node.js crypto library used in the provided code snippet.
// However, here is a potential refactoring using Java's cryptography libraries:

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Main15 {
    public static void main(String[] args) {
        try {
            String key = "00010203050607080a0b0c0d0f101112";
            byte[] keyBytes = javax.xml.bind.DatatypeConverter.parseHexBinary(key);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            // Assuming there is some plaintext to encrypt
            String plaintext = "The quick brown fox jumps over the lazy dog";
            byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
            String encryptedString = Base64.getEncoder().encodeToString(encryptedBytes);

            System.out.println("Encrypted text: " + encryptedString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
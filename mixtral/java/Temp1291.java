import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Temp1291 {
    public static void main(String[] args) throws Exception {
        // Generate a key for AES
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // for example
        SecretKey secretKey = keyGen.generateKey();
        
        // Create AES cipher instance
        Cipher cipher = Cipher.getInstance("AES");

        // Sample input
        String input = "Hello World";

        // Encrypt
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] cipherBytes = cipher.doFinal(input.getBytes());
        String encryptedText = Base64.getEncoder().encodeToString(cipherBytes);
        System.out.println("Encrypted Text: " + encryptedText);

        // Decrypt
        byte[] decodedCipherBytes = Base64.getDecoder().decode(encryptedText);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] plainText = cipher.doFinal(decodedCipherBytes);
        System.out.println("Decrypted Text: " + new String(plainText));
    }
}
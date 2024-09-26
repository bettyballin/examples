import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.security.Key;
import javax.crypto.KeyGenerator;

public class Temp1708 {
    public static void main(String[] args) throws Exception {
        // Generate a new IV for each encryption
        SecureRandom random = new SecureRandom();
        byte[] ivBytes = new byte[16]; // 128 bits
        random.nextBytes(ivBytes);

        IvParameterSpec ivParams = new IvParameterSpec(ivBytes);

        // Generate a secret key for AES encryption
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        Key key = keyGen.generateKey();

        // Initialize cipher for encryption
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, ivParams);

        // Example plaintext
        String plaintext = "Hello, World!";
        byte[] encrypted = cipher.doFinal(plaintext.getBytes());

        // Initialize cipher for decryption using the same IV
        Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher2.init(Cipher.DECRYPT_MODE, key, ivParams);

        // Decrypt the previously encrypted text
        byte[] decrypted = cipher2.doFinal(encrypted);
        String decryptedText = new String(decrypted);

        // Print decrypted text
        System.out.println("Decrypted text: " + decryptedText);
    }
}
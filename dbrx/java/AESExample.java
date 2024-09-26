import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class AESExample {
    public static void main(String[] args) throws Exception {
        // Generate a 256-bit key using the unlimited strength policy files
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        SecureRandom random = new SecureRandom();
        int keySize = 128; // Change this to your desired value (e.g 192 or 256)
        if (keySize > Cipher.getMaxAllowedKeyLength("AES")) {
            System.out.println("Using unlimited strength policy files is required for a " + keySize + "-bit key.");
            return;
        }
        keyGen.init(keySize, random);
        SecretKey secretKey = keyGen.generateKey();

        // Initialize the cipher with your desired mode and padding
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(new byte[16]); // Use a secure IV for CBC mode

        // Encrypt some data using AES-256-CBC-PKCS5Padding
        String plainText = "This is the text to encrypt.";
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        byte[] encryptedData = cipher.doFinal(plainText.getBytes("UTF-8"));

        System.out.println("Encrypted Data: " + Base64.getEncoder().encodeToString(encryptedData));
    }
}
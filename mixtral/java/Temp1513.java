import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Temp1513 {
    public static void main(String[] args) throws Exception {
        String decryptedText = "Hello, World!";

        // Generate random 128-bit AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();

        // Generate random IV
        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[16];
        random.nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // Encrypt
        Cipher aesCBCEncryptor = Cipher.getInstance("AES/CBC/PKCS5Padding");
        aesCBCEncryptor.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        byte[] encryptedData = aesCBCEncryptor.doFinal(decryptedText.getBytes("UTF-8"));

        // Decrypt
        Cipher aesCBCDecryptor = Cipher.getInstance("AES/CBC/PKCS5Padding");
        aesCBCDecryptor.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
        byte[] originalData = aesCBCDecryptor.doFinal(encryptedData);

        // Print results
        System.out.println("Original Text: " + decryptedText);
        System.out.println("Encrypted Text (Base64): " + Base64.getEncoder().encodeToString(encryptedData));
        System.out.println("Decrypted Text: " + new String(originalData, "UTF-8"));
    }
}
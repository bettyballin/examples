import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;

public class Temp584 {
    private static SecretKey secKey;
    private static IvParameterSpec ivspec;

    public static void main(String[] args) {
        try {
            // Generate AES key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // for AES-128
            secKey = keyGen.generateKey();

            // Generate IV
            byte[] iv = new byte[16];
            ivspec = new IvParameterSpec(iv);

            String originalText = "Hello, World!";
            System.out.println("Original Text: " + originalText);

            String encryptedText = encryptData(originalText);
            System.out.println("Encrypted Text: " + encryptedText);

            String decryptedText = decryptData(encryptedText);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encryptData(String textToEncrypt) {
        try {
            byte[] byteToEncrypt = textToEncrypt.getBytes(StandardCharsets.UTF_8);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE, secKey, ivspec);

            byte[] encryptedBytes = cipher.doFinal(byteToEncrypt);

            // Convert the bytes to Base64 String
            return Base64.getEncoder().encodeToString(encryptedBytes);

        } catch (Exception e) {
            throw new RuntimeException("Failed during encryption", e);
        }
    }

    public static String decryptData(String textToDecrypt) {
        try {
            byte[] encryptedBytes = Base64.getDecoder().decode(textToDecrypt);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            cipher.init(Cipher.DECRYPT_MODE, secKey, ivspec);

            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

            return new String(decryptedBytes, StandardCharsets.UTF_8);

        } catch (Exception e) {
            throw new RuntimeException("Failed during decryption", e);
        }
    }
}
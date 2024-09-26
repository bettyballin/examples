import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    private static final String ALGORITHM = "AES";

    public static void main(String[] args) throws Exception {
        String text = "MySuperSecretPassword!";

        // Generate a new AES key
        SecretKey secretKey = generateKey();

        // Encrypt the Text then print it out in an array
        byte[] encryptedMessage = encryptAES(text, secretKey);
        System.out.println("Encrypted Message: " + Arrays.toString(encryptedMessage));

        // Decrypt the EncryptedText then print it out
        String decryptedText = decryptAES(encryptedMessage, secretKey);
        System.out.println("Decrypted Message: " + decryptedText);
    }

    public static byte[] encryptAES(String text, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
    }

    public static String decryptAES(byte[] encryptedMessage, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(encryptedMessage), StandardCharsets.UTF_8);
    }

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128); // for example 128 bit key
        return keyGen.generateKey();
    }
}
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public class Temp866 {
    public static void main(String[] args) throws Exception {
        String messageToBeEncoded = "Hello, World!";
        SecretKey secretKey = generateAESKey(); // Generate AES Key

        // Encryption
        byte[] iv = generateRandomIV(); // Generate random IV
        IvParameterSpec ivParam = new IvParameterSpec(iv);

        Cipher cipherEncrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipherEncrypt.init(Cipher.ENCRYPT_MODE, secretKey, ivParam);
        byte[] encryptedMessageBytes = cipherEncrypt.doFinal(messageToBeEncoded.getBytes(StandardCharsets.UTF_8));

        // Prepend IV to the beginning of your message
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(iv);
        outputStream.write(encryptedMessageBytes);
        byte[] combinedData = outputStream.toByteArray();

        String encryptedBase64 = Base64.getEncoder().encodeToString(combinedData);
        System.out.println("Encrypted Base64: " + encryptedBase64);

        // Decryption
        Cipher cipherDecrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");

        byte[] combinedBytes = Base64.getDecoder().decode(encryptedBase64);

        IvParameterSpec ivParamForDecryption = new IvParameterSpec(Arrays.copyOfRange(combinedBytes, 0, 16));
        cipherDecrypt.init(Cipher.DECRYPT_MODE, secretKey, ivParamForDecryption);

        byte[] decryptedMessageBytes = cipherDecrypt.doFinal(Arrays.copyOfRange(combinedBytes, 16, combinedBytes.length));
        String originalText = new String(decryptedMessageBytes, StandardCharsets.UTF_8);

        System.out.println("Original Text: " + originalText);
    }

    private static byte[] generateRandomIV() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return iv;
    }

    private static SecretKey generateAESKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        return keyGenerator.generateKey();
    }
}
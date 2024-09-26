import java.security.*;
import java.security.spec.KeySpec;
import java.nio.charset.StandardCharsets;
import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;

public class PMAdminKeyTest {

    public static void main(String[] args) throws Exception {
        // Requirement is to generate Key based on password and salt
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

        char[] passwordChars = "password".toCharArray();

        byte[] saltBytes = "salt".getBytes(StandardCharsets.UTF_8);

        int iterationsCount = 1000;

        KeySpec keySpec = new PBEKeySpec(passwordChars, saltBytes, iterationsCount, 24 * Byte.SIZE);

        SecretKey secretKey = secretKeyFactory.generateSecret(keySpec);

        SecretKey secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "DESede");

        System.out.println("secret key algorithm: " + secretKeySpec.getAlgorithm());

        // Existing encrypt and decrypt code

        Cipher cipherEncryption = Cipher.getInstance("DESede/ECB/PKCS5Padding");

        byte[] dataToBeEncrypted = "12345678".getBytes(StandardCharsets.UTF_8);

        // Encrypt the message
        cipherEncryption.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedData = cipherEncryption.doFinal(dataToBeEncrypted);
        System.out.println("Encrypted data: " + new String(encryptedData, StandardCharsets.ISO_8859_1));

        // Decrypt the message
        Cipher cipherDecryption = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipherDecryption.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptedData = cipherDecryption.doFinal(encryptedData);
        System.out.println("Decrypted data: " + new String(decryptedData, StandardCharsets.UTF_8));
    }
}
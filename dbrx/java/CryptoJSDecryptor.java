Here's the corrected and executable code:


import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public class CryptoJSDecryptor {

    public static void main(String[] args) throws Exception {
        String encryptedData = "U2FsdGVkX18xMjPC0w==";
        char[] passphrase = "<PASSWORD>".toCharArray();

        byte[] saltAndEncryptedBytes = Base64.getDecoder().decode(encryptedData);
        int ivLengthInBytes = 16;
        byte[] ivBytes = Arrays.copyOfRange(saltAndEncryptedBytes, 0, ivLengthInBytes);

        // Extract Salt & Encrypted Data
        byte[] encryptedMessageWithSalt = new byte[saltAndEncryptedBytes.length - ivLengthInBytes];
        System.arraycopy(saltAndEncryptedBytes, ivLengthInBytes, encryptedMessageWithSalt, 0, saltAndEncryptedBytes.length - ivLengthInBytes);

        // Derive Key from Passphrase
        int keySize = 128;
        int iterationCount = 65536;
        byte[] salt = Arrays.copyOfRange(encryptedMessageWithSalt, 0, 8);

        PBEKeySpec spec = new PBEKeySpec(passphrase, salt, iterationCount, keySize);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] keyBytes = keyFactory.generateSecret(spec).getEncoded();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

        // Decrypt the message
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(ivBytes));
        byte[] decryptedBytes = cipher.doFinal(Arrays.copyOfRange(encryptedMessageWithSalt, 8, encryptedMessageWithSalt.length));

        String decryptedMessage = new String(decryptedBytes, StandardCharsets.UTF_8);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}
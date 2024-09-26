import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Temp494 {
    public static void main(String[] args) {
        try {
            String message = "Hello, World!";
            byte[] secretKey = generateSecretKey();

            byte[] iv = generateIv(message, secretKey);
            byte[] encryptedMessage = encrypt(message, secretKey, iv);

            System.out.println("IV: " + Arrays.toString(iv));
            System.out.println("Encrypted Message: " + Arrays.toString(encryptedMessage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] generateSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // for example
        SecretKey secretKey = keyGen.generateKey();
        return secretKey.getEncoded();
    }

    // Generate a deterministic IV for GCM mode
    public static byte[] generateIv(String message, byte[] secretKey) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(message.getBytes(StandardCharsets.UTF_8));
        digest.update(secretKey);
        return Arrays.copyOfRange(digest.digest(), 0, 12); // GCM needs a 12-16 byte IV
    }

    // Encrypt the message using AES-GCM
    public static byte[] encrypt(String message, byte[] secretKey, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        SecretKeySpec keySpec = new SecretKeySpec(secretKey, "AES");
        GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv); // 128-bit authentication tag length
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmSpec);

        byte[] encryptedData = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
        return encryptedData;
    }
}
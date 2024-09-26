import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Temp160 {
    private static byte[] iv;
    private static SecretKeySpec key;

    public static void main(String[] args) {
        try {
            key = getAESKey();
            iv = generateIV();
            String message = "Hello, World!";
            byte[] encryptedMessage = encryptAES(message);
            byte[] decryptedMessage = decryptAES(encryptedMessage);
            System.out.println("Original message: " + message);
            System.out.println("Encrypted message: " + new String(encryptedMessage));
            System.out.println("Decrypted message: " + new String(decryptedMessage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] encryptAES(String message) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivParams = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, ivParams);
        return cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
    }

    public static byte[] decryptAES(byte[] encryptedMessage) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivParams = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, key, ivParams);
        return cipher.doFinal(encryptedMessage);
    }

    private static SecretKeySpec getAESKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();
        return new SecretKeySpec(secretKey.getEncoded(), "AES");
    }

    private static byte[] generateIV() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return iv;
    }
}
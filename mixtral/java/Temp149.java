import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;

public class Temp149 {
    public static void main(String[] args) {
        try {
            String message = "Hello, World!";
            byte[] encryptedMessage = encryptAES(message);
            System.out.println("Encrypted message: " + new String(encryptedMessage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] encryptAES(String message) throws Exception {
        // Generate random key
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom sr = new SecureRandom();

        int keysize = 128;

        kgen.init(keysize, sr);

        SecretKey secretKey = kgen.generateKey();

        // Encrypt
        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        return cipher.doFinal(message.getBytes("UTF-8"));
    }
}
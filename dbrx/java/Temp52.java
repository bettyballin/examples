import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class Temp52 {
    public static void main(String[] args) {
        try {
            // Generate a random IV
            SecureRandom secureRandom = new SecureRandom();
            byte[] ivBytes = new byte[16]; // AES block size is always fixed at 128 bits (or 16 bytes)
            secureRandom.nextBytes(ivBytes);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

            // Example secret key (must be 16 bytes for AES-128)
            byte[] keyBytes = "1234567890123456".getBytes();
            SecretKeySpec skeySpec = new SecretKeySpec(keyBytes, "AES");

            // Initialize the cipher for encryption
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);

            System.out.println("Cipher initialized successfully with IV and SecretKeySpec.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
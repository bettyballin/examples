import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class Main91 {
    public static void main(String[] args) {
        try {
            SecureRandom randomSecureRandom = new SecureRandom();
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] iv = new byte[cipher.getBlockSize()];
            randomSecureRandom.nextBytes(iv);
            IvParameterSpec ivParams = new IvParameterSpec(iv);
            // Cipher initialization and usage would go here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
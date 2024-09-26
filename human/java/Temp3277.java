import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class Temp3277 {
    public static void main(String[] args) {
        try {
            SecureRandom randomSecureRandom = new SecureRandom();
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] iv = new byte[cipher.getBlockSize()];
            randomSecureRandom.nextBytes(iv);
            IvParameterSpec ivParams = new IvParameterSpec(iv);
            // Now you can use ivParams with the cipher
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
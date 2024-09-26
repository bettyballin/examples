import java.util.Base64;
import javax.crypto.Cipher;

public class EncryptionHelper {
    public static String encryptString(String string, Cipher cipher) {
        try {
            return Base64.getMimeEncoder().encodeToString(cipher.doFinal(string.getBytes()));
        } catch (Exception e) {
            // Handle exception or throw it
            return null;
        }
    }
}
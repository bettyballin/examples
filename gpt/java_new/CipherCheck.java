import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class CipherCheck {

    private static boolean isGcmModeSupported() {
        try {
            Cipher.getInstance("AES/GCM/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        if (!isGcmModeSupported()) {
            // Skip the test or handle the lack of support appropriately
        }
    }
}
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class CipherExample3 {
    public static void main(String[] args) {
        try {
            byte[] data = new byte[256]; // Placeholder for actual data
            byte[] encrypted = new byte[256]; // Placeholder for encrypted data
            byte[] keyBytes = new byte[16]; // Placeholder for actual key bytes
            Key key = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            cipher.updateAAD(data, 0, 16); // first 128 bits are authenticated
            cipher.update(data, 16, 16, encrypted, 0); // next 128 bits are encrypted

            // Finalize encryption if necessary (not shown)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
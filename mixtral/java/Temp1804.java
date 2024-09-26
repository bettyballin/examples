import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class Temp1804 {
    public static void main(String[] args) {
        Temp1804 temp = new Temp1804();
        System.out.println("GCM Support: " + temp.checkGcmSupport());
    }

    public boolean checkGcmSupport() {
        try {
            Cipher c = Cipher.getInstance("AES/GCM/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            // GCM not supported
            return false;
        }
    }
}
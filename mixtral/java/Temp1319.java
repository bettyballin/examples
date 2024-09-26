import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class Temp1319 {
    public static void main(String[] args) {
        try {
            Cipher ciper = Cipher.getInstance("RSA/ECB/OAEPPadding");
            //or
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }
}
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class Temp3446 {
    public static void main(String[] args) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
            System.out.println("Cipher successfully created: " + cipher);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }
}
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class Temp1272 {
    public static void main(String[] args) {
        try {
            Cipher crypt = Cipher.getInstance("AES/ECB/NoPadding");
            System.out.println("Cipher initialized: " + crypt);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }
}
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class Temp74 {
    public static void main(String[] args) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            System.out.println("Cipher initialized successfully!");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }
}
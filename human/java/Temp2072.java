import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class Temp2072 {
    public static void main(String[] args) {
        try {
            Cipher output = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            System.out.println("Cipher instance created successfully.");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }
}
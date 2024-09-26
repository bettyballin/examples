import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class Temp1021 {
    public static void main(String[] args) {
        try {
            Cipher cipher1 = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            System.out.println("Cipher 1: " + cipher1.getAlgorithm());

            Cipher cipher2 = Cipher.getInstance("AES/ECB/ISO10126d2Padding");
            System.out.println("Cipher 2: " + cipher2.getAlgorithm());
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }
}
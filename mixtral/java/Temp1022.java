import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class Temp1022 {
    public static void main(String[] args) {
        try {
            Cipher cipher1 = Cipher.getInstance("AES/GCM/NoPadding");
            System.out.println("Cipher instance with AES/GCM/NoPadding created successfully.");

            Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            System.out.println("Cipher instance with AES/CBC/PKCS5PADDING created successfully.");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }
}
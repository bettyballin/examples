import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class Temp1366 {
    private static Cipher AESCipher = null;
    private static Cipher RSACipher = null;

    static {
        try {
            AESCipher = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            RSACipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("AES Cipher: " + AESCipher);
        System.out.println("RSA Cipher: " + RSACipher);
    }
}
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Temp277 {
    public static void main(String[] args) {
        try {
            String string = "Hello, World!";
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            
            byte[] crypted = cipher.doFinal(string.getBytes("UTF-8"));
            String encodedString = Base64.getMimeEncoder().encodeToString(crypted);
            System.out.println(encodedString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
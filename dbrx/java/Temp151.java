import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class Temp151 {
    public static void main(String[] args) {
        try {
            byte[] PRFkey = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
            SecretKeySpec encryptionKey = new SecretKeySpec(PRFkey, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); // Use ECB for simplicity
            cipher.init(Cipher.ENCRYPT_MODE, encryptionKey);
            
            String plaintext = "Hello, World!";
            byte[] encryptedData = cipher.doFinal(plaintext.getBytes("UTF-8"));
            
            System.out.println("Encrypted Data: " + Arrays.toString(encryptedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
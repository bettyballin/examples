import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp1301 {
    public static void main(String[] args) {
        try {
            String pw = "This is a very strong password";
            String pt = "This is some example plaintext";

            // Generate AES key from password
            byte[] key = pw.getBytes("UTF-8");
            SecretKeySpec aesKey = new SecretKeySpec(key, "AES");

            // Encrypt plaintext
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encryptedBytes = cipher.doFinal(pt.getBytes("UTF-8"));
            String encrypted = Base64.getEncoder().encodeToString(encryptedBytes);

            System.out.println("Encrypted: " + encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
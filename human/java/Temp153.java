import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class Temp153 {
    private static Cipher ecipher;

    public static void main(String[] args) {
        try {
            // Initialize the cipher with a key
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            SecretKey key = keygen.generateKey();
            ecipher = Cipher.getInstance("AES");
            ecipher.init(Cipher.ENCRYPT_MODE, key);

            // String to be encrypted
            String str = "Hello World";

            byte[] utf8 = str.getBytes("UTF8");
            byte[] enc = ecipher.doFinal(utf8);

            String encodedString = Base64.getEncoder().encodeToString(enc);
            System.out.println("Encoded String: " + encodedString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
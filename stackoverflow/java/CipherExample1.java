import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class CipherExample1 {
    private static final String ALGORITHM = "AES";

    public static void main(String[] args) {
        try {
            String key = "mysecretpassword";
            Key aesKey = new SecretKeySpec(key.getBytes(), ALGORITHM);

            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal("HELLO WORLD".getBytes());

            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            byte[] decrypted = cipher.doFinal(encrypted);

            System.out.println(new String(decrypted));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Arrays;

public class Temp406 {

    public static void main(String[] args) {
        try {
            String password = "myPassword";
            byte[] data = "HelloWorld123456".getBytes(); // 16 bytes for AES NoPadding
            byte[] encryptedData = encrypt(data, password);
            System.out.println(Arrays.toString(encryptedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] encrypt(byte[] data, String password) throws Exception {
        Key key = generateKey(password);
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    private static Key generateKey(String password) throws Exception {
        byte[] keyBytes = Arrays.copyOf(password.getBytes(), 16); // Use first 16 bytes for AES key
        return new SecretKeySpec(keyBytes, "AES");
    }
}
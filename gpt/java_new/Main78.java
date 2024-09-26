import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class Main78 {
    public static void main(String[] args) {
        try {
            String keyString = "1234567890123456"; // Example key (16 chars for AES-128)
            Key key = new SecretKeySpec(keyString.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            String plaintext = "Hello, World!";
            byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());

            // For demonstration purposes: printing encrypted bytes
            for (byte b : encryptedBytes) {
                System.out.print(String.format("%02X ", b));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
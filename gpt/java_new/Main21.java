import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Main21 {
    public static String encryptAES(String message) throws Exception {
        String secretKey = "JohnIsAwesome!1!";
        byte[] keyBytes = Arrays.copyOf(secretKey.getBytes("UTF-8"), 16); // AES keys are 128, 192 or 256 bits.
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(message.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static void main(String[] args) throws Exception {
        String originalMessage = "Secret Message";
        String encryptedMessage = encryptAES(originalMessage);
        System.out.println("Encrypted Message: " + encryptedMessage);
    }
}
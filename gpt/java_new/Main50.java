import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Main50 {

    public static void main(String[] args) {
        try {
            String keyString = "00000000000000000000000000000000";
            byte[] keyBytes = keyString.getBytes();
            SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            String plainText = "This is a plain text.";
            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
            String encodedBase64 = Base64.getEncoder().encodeToString(encryptedBytes);

            System.out.println("Encrypted (base64): " + encodedBase64);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
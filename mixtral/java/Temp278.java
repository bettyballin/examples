import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Temp278 {
    public static void main(String[] args) {
        try {
            String string = "YourBase64EncodedCipherTextHere";
            String key = "YourSecretKeyHere"; // 16 chars for AES-128, adjust as needed

            byte[] cipherText = Base64.getDecoder().decode(string);

            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            String decryptedText = new String(cipher.doFinal(cipherText), "UTF-8");
            System.out.println(decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
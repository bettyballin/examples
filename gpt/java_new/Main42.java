import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Main42 {
    public static void main(String[] args) {
        try {
            String keyString = "tvnw63ufg9gh5392";
            byte[] keyBytes = keyString.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

            Cipher decipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            decipher.init(Cipher.DECRYPT_MODE, key);

            // Assuming you have your encrypted data in `encryptedData` byte array
            // byte[] encryptedData = ...
            // byte[] plainText = decipher.doFinal(encryptedData);
            // System.out.println(new String(plainText, StandardCharsets.UTF_8));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
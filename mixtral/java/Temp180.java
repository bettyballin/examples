import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Arrays;

public class Temp180 {
    public static void main(String[] args) {
        try {
            String key = "someData";
            byte[] rawKey = Arrays.copyOf(key.getBytes(), 16);
            SecretKeySpec sks = new SecretKeySpec(rawKey, "AES");

            Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE, sks);
            
            String encodedStringFromWebApp = "encodedStringFromWebApp"; // This should be a valid Base64 encoded string from your web app
            byte[] decodedBytes = Base64.getDecoder().decode(encodedStringFromWebApp);
            byte[] decodedData = c.doFinal(decodedBytes);

            // Convert the bytes back to a string
            String decryptedText = new String(decodedData);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
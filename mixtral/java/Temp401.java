import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLDecoder;
import java.util.Base64;

public class Temp401 {
    public static void main(String[] args) throws Exception {
        byte key_bytes[] = "12345678".getBytes();
        SecretKeySpec _keyspec = new SecretKeySpec(key_bytes, "DES");
        Cipher dcipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        dcipher.init(Cipher.DECRYPT_MODE, _keyspec);

        String value = "your_encoded_value_here"; // Placeholder for the encoded value
        String decodedURL = URLDecoder.decode(value, "UTF-8").replaceAll("%20", " ");
        byte[] base64DecodedData = Base64.getDecoder().decode(decodedURL);

        // Decrypt
        byte[] decryptedData = dcipher.doFinal(base64DecodedData);
        String decryptedString = new String(decryptedData);

        System.out.println("Decrypted String: " + decryptedString);
    }
}
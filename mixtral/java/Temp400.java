import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.util.Base64;

public class Temp400 {
    public static void main(String[] args) throws Exception {
        String value = "yourStringToEncrypt"; // Replace with the actual string to encrypt

        byte[] key_bytes = "12345678".getBytes();
        SecretKeySpec _keyspec = new SecretKeySpec(key_bytes, "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, _keyspec);

        byte[] utf8 = value.getBytes();

        // Encrypt
        byte[] encryptedData = cipher.doFinal(utf8);

        String base64Encoded = Base64.getUrlEncoder().encodeToString(encryptedData);

        String encodedUrl = URLEncoder.encode(base64Encoded, "UTF-8");

        System.out.println(encodedUrl);
    }
}
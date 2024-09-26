import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Temp1227 {
    public static void main(String[] args) {
        try {
            String base64EncodedKey = "uQsaW+WMUrjcsq1HMf+2JQ==";
            byte[] decodedKey = Base64.decodeBase64(base64EncodedKey);
            SecretKeySpec key = new SecretKeySpec(decodedKey, "AES");

            // Example to show the key in UTF-8 format
            String utf8Key = new String(key.getEncoded(), java.nio.charset.StandardCharsets.UTF_8);
            System.out.println("Key in UTF-8 format: " + utf8Key);

            // Encrypt or Decrypt using the key
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            String plainText = "Hello, World!";
            byte[] encrypted = cipher.doFinal(plainText.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            System.out.println("Encrypted text: " + Base64.encodeBase64String(encrypted));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
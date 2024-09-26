import org.apache.commons.codec.binary.Hex;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class Temp125 {
    public static void main(String[] args) {
        try {
            String id = "example_id";
            
            // Generate MD5 hash
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md5.digest(id.getBytes(StandardCharsets.UTF_8));
            String hexKey = Hex.encodeHexString(md5Bytes);

            // Store the `hexKey` in a secure location

            // Later when you need to use it for encryption/decryption
            SecretKeySpec keySpec = new SecretKeySpec(Hex.decodeHex(hexKey.toCharArray()), "AES");
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.DECRYPT_MODE, keySpec);

            // Example encrypted data for decryption
            byte[] encryptedData = new byte[]{ /* your encrypted data here */ };
            byte[] decryptedData = c.doFinal(encryptedData);

            // Use the decryptedData as needed
            System.out.println(new String(decryptedData, StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
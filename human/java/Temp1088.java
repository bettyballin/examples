import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Temp1088 {
    public static void main(String[] args) {
        try {
            String value = "your_encrypted_string_here";
            String key = "your_key_here"; // 16 bytes key for AES-128

            String decrypted = decrypt(value, key);
            System.out.println("Decrypted value: " + decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String decrypt(String value, String key) throws Exception {
        String decryptd = URLDecoder.decode(value, StandardCharsets.UTF-8.name());
        byte[] dec = Base64.getDecoder().decode(decryptd);
        
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF-8), "AES");
        Cipher dcipher = Cipher.getInstance("AES");
        dcipher.init(Cipher.DECRYPT_MODE, skeySpec);
        
        byte[] utf8 = dcipher.doFinal(dec);  
        return new String(utf8, StandardCharsets.UTF-8);
    }
}
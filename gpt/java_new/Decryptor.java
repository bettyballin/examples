import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Decryptor {
    public String decrypt(String value) throws Exception {
        byte[] keyBytes = "12345678".getBytes(StandardCharsets.UTF_8);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "DES");
        Cipher dcipher = Cipher.getInstance("DES");
        
        dcipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decodedValue = Base64.getDecoder().decode(value);
        byte[] decryptedVal = dcipher.doFinal(decodedValue);
        return new String(decryptedVal, StandardCharsets.UTF_8);
    }
}
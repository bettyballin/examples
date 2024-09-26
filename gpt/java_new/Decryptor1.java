import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Decryptor1 {
    private static final byte[] KEY = new byte[] { /* your key bytes here */ };

    public String decrypt(String enc) throws Exception {
        SecretKeySpec key = new SecretKeySpec(KEY, "AES");
        Cipher crypt = Cipher.getInstance("AES");
        crypt.init(Cipher.DECRYPT_MODE, key);
        
        byte[] decodedValue = Base64.getDecoder().decode(enc);
        byte[] decryptedBytes = crypt.doFinal(decodedValue);
        
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}